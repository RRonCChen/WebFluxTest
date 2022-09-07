package ron.example.demo.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class PersonHandler {

    private final PersonRepository personRepository;

    public Mono<ServerResponse> createPerson(ServerRequest request) {
        return request.bodyToMono(Person.class)
                .flatMap(person -> personRepository.save(person))
                .flatMap(person -> ServerResponse.created(URI.create("/posts/" + person.getId())).build());
    }

    public Mono<ServerResponse> getPerson(ServerRequest request) {
        return personRepository.findById(Integer.valueOf(request.pathVariable("id")))
                .flatMap(person -> ServerResponse.ok().body(Mono.just(person), Person.class))
                .switchIfEmpty(ServerResponse.notFound().build());

    }

    public Mono<ServerResponse> deletePerson(ServerRequest request) {
        return ServerResponse
                .noContent()
                .build(personRepository.deleteById(Integer.valueOf(request.pathVariable("id"))));
    }
}
