package co.com.davito.aplicacionempresarial.routers;

import co.com.davito.aplicacionempresarial.models.QuestionDTO;
import co.com.davito.aplicacionempresarial.usecases.GetByIdQuestionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetByIdQuestionRouter {

    @Bean
    public RouterFunction<ServerResponse> getByIdQuestion(GetByIdQuestionUseCase getUseCase) {
        return route(
            GET("/api/get/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getUseCase.apply(
                                request.pathVariable("id")),
                                QuestionDTO.class
                        )).onErrorResume(throwable ->
                                ServerResponse
                                        .badRequest()
                                        .body(throwable.getMessage(),String.class))
        );
    }

}
