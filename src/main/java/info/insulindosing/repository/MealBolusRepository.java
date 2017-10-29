/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.repository;

import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import info.insulindosing.model.treatments.MealBolus;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public interface MealBolusRepository extends MongoRepository <MealBolus, String> {
    List<MealBolus> findByCreatedDateBetweenAndEventType(Instant startDate, Instant endDate, String eventType);
    List<MealBolus> findByModifiedDateBetweenAndEventType(Instant startDate, Instant endDate, String eventType);
    List<MealBolus> findByCreatedBy(String createdBy);
    List<MealBolus> findByLoopEnteredByAndEventType(String loopEnteredBy, String eventType);
}
