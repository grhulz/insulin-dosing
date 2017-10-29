/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.repository;

import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import info.insulindosing.model.treatments.TempBasal;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public interface TempBasalRepository extends MongoRepository <TempBasal, String> {
    List<TempBasal> findByCreatedDateBetween(Instant startDate, Instant endDate);
    List<TempBasal> findByModifiedDateBetween(Instant startDate, Instant endDate);
    List<TempBasal> findByCreatedBy(String createdBy);
    List<TempBasal> findByLoopEnteredByAndEventType(String loopEnteredBy, String eventType);
}
