package ron.example.demo.oldAnnotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/annotation")
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> getHello() {
        return Mono.just("hello");
    }

    @GetMapping("/helloWorld")
    public Flux<String> getHelloWorld() {
        return Flux.just("hello", "world")
                .delayElements(Duration.ofSeconds(2));
    }
}
