package co.com.davito.aplicacionempresarial.usecases;

import co.com.davito.aplicacionempresarial.repositories.AnswerRepository;
import co.com.davito.aplicacionempresarial.repositories.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class DeleteQuestionUseCase implements Function<String, Mono<Void>> {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public DeleteQuestionUseCase(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }


    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "Id es requerido");
        return questionRepository.deleteById(id)
                .switchIfEmpty(Mono.defer(() -> answerRepository.deleteByQuestionId(id)));
    }
}
