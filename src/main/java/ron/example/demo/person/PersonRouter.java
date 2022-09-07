package ron.example.demo.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PersonRouter {

    @Bean
    public RouterFunction<ServerResponse> personRoute(PersonHandler personHandler) {
        return RouterFunctions
                .route(GET("/person/{id}"), personHandler::getPerson)
                .andRoute(POST("/person"), personHandler::createPerson)
                .andRoute(DELETE("/person/{id}"), personHandler::deletePerson);
    }
}
