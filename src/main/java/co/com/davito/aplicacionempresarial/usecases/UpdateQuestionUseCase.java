package co.com.davito.aplicacionempresarial.usecases;

import co.com.davito.aplicacionempresarial.collections.Question;
import co.com.davito.aplicacionempresarial.mapperutils.MapperUtils;
import co.com.davito.aplicacionempresarial.models.QuestionDTO;
import co.com.davito.aplicacionempresarial.repositories.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UpdateQuestionUseCase implements SaveQuestion{

    private final QuestionRepository questionRepository;
    private final MapperUtils mapperUtils;

    public UpdateQuestionUseCase(QuestionRepository questionRepository, MapperUtils mapperUtils) {
        this.questionRepository = questionRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(QuestionDTO questionDTO) {
        Objects.requireNonNull(questionDTO.getId(), "el id de la pregunta es requerido");
        return questionRepository
                .save(mapperUtils.mapperToQuestion(questionDTO.getId()).apply(questionDTO))
                .map(Question::getId);
    }
}
