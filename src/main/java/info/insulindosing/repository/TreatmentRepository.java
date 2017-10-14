/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.repository;

import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import info.insulindosing.model.Treatment;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public interface TreatmentRepository extends MongoRepository <Treatment, Long> {
    List<Treatment> findByCreatedDateBetween(Instant startDate, Instant endDate);
    List<Treatment> findByModifiedDateBetween(Instant startDate, Instant endDate);
}
