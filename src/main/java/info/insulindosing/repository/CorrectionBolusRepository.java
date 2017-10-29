package info.insulindosing.repository;

import info.insulindosing.model.treatments.CorrectionBolus;
import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public interface CorrectionBolusRepository extends MongoRepository <CorrectionBolus, String> {
    List<CorrectionBolus> findByCreatedDateBetween(Instant startDate, Instant endDate);
    List<CorrectionBolus> findByModifiedDateBetween(Instant startDate, Instant endDate);
    List<CorrectionBolus> findByCreatedBy(String createdBy);
    List<CorrectionBolus> findByLoopEnteredByAndEventType(String loopEnteredBy, String eventType);
}
