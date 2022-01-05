package co.com.davito.aplicacionempresarial.routers;

import co.com.davito.aplicacionempresarial.models.QuestionDTO;
import co.com.davito.aplicacionempresarial.usecases.GetAllQuestionsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllQuestionsRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllQuestions(GetAllQuestionsUseCase getAllQuestionsUseCase){
        return route(GET("/api/getAll"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllQuestionsUseCase.get(), QuestionDTO.class))

        );
    }
}
