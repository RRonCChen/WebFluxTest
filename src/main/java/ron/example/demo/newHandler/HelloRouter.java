package ron.example.demo.newHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class HelloRouter {
    @Bean
    public RouterFunction<ServerResponse> helloRoute(HelloHandler helloHandler) {
        return RouterFunctions
                .route(GET("/route/hello"), helloHandler::hello)
                .andRoute(GET("/route/helloWorld"), helloHandler::helloWorld);
    }
}
