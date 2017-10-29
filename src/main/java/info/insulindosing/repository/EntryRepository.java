/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.repository;

import info.insulindosing.model.entries.Entry;
import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public interface EntryRepository extends MongoRepository <Entry, String> {
    List<Entry> findByCreatedDateBetween(Instant startDate, Instant endDate);
    List<Entry> findByModifiedDateBetween(Instant startDate, Instant endDate);
    List<Entry> findByEntryType(String type);
}
