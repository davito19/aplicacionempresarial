package co.com.davito.aplicacionempresarial.usecases;

import co.com.davito.aplicacionempresarial.collections.Question;
import co.com.davito.aplicacionempresarial.mapperutils.MapperUtils;
import co.com.davito.aplicacionempresarial.models.QuestionDTO;
import co.com.davito.aplicacionempresarial.repositories.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateQuestionUseCase implements SaveQuestion {

    private final QuestionRepository questionRepository;
    private final MapperUtils mapperUtils;

    public CreateQuestionUseCase(QuestionRepository questionRepository, MapperUtils mapperUtils) {
        this.questionRepository = questionRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(QuestionDTO newQuestion) {
        return questionRepository
                .save(mapperUtils.mapperToQuestion(null).apply(newQuestion))
                .map(Question::getId);
    }
}
