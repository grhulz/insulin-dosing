/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.repository;

import info.insulindosing.model.devicestatus.LoopStatus;
import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public interface LoopStatusRepository extends MongoRepository <LoopStatus, String> {
    List<LoopStatus> findByCreatedDateBetween(Instant startDate, Instant endDate);
    List<LoopStatus> findByModifiedDateBetween(Instant startDate, Instant endDate);
    
    @Query("{'loop.name': ?0}")
    List<LoopStatus> findByName(final String name);    
}
