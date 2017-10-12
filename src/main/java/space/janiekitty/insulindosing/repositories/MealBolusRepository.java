/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.janiekitty.insulindosing.repositories;

import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import space.janiekitty.insulindosing.models.MealBolus;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public interface MealBolusRepository extends MongoRepository <MealBolus, Long> {
    List<MealBolus> findByCreatedDateBetween(Instant startDate, Instant endDate);
    List<MealBolus> findByModifiedDateBetween(Instant startDate, Instant endDate);
}
