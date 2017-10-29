package info.insulindosing.repository;

import info.insulindosing.model.treatments.BGCheck;
import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public interface BGCheckRepository extends MongoRepository <BGCheck, String> {
    List<BGCheck> findByCreatedDateBetween(Instant startDate, Instant endDate);
    List<BGCheck> findByModifiedDateBetween(Instant startDate, Instant endDate);
    List<BGCheck> findByCreatedBy(String createdBy);
    List<BGCheck> findByLoopEnteredByAndEventType(String loopEnteredBy, String eventType);
}
