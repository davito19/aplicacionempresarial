package co.com.davito.aplicacionempresarial.repositories;

import co.com.davito.aplicacionempresarial.collections.Question;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QuestionRepository extends ReactiveCrudRepository<Question, String> {
    Flux<Question> findByUserId(String userId);
}
