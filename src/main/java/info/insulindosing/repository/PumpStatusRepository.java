/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.repository;

import info.insulindosing.model.PumpStatus;
import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public interface PumpStatusRepository extends MongoRepository <PumpStatus, String> {
    List<PumpStatus> findByCreatedDateBetween(Instant startDate, Instant endDate);
    List<PumpStatus> findByModifiedDateBetween(Instant startDate, Instant endDate);
    
    @Query("{'pump.pumpId': ?0}")
    List<PumpStatus> findByPumpId(final String pumpId);    
}
