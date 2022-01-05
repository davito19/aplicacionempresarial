package co.com.davito.aplicacionempresarial.usecases;

import co.com.davito.aplicacionempresarial.models.QuestionDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveQuestion {
    Mono<String> apply(@Valid QuestionDTO questionDTO);
}
