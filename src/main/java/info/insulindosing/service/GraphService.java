package info.insulindosing.service;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */

import info.insulindosing.model.entries.Entry;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import info.insulindosing.repository.EntryRepository;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import info.insulindosing.service.util.DateUtilities;

@Service
public class GraphService {
    private EntryRepository entryRepository;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final Logger logger = LogManager.getLogger(GraphService.class);

    @Autowired
    public GraphService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<Entry> graphEntries(String startDateString, String endDateString){
        DateUtilities dateUtilities = new DateUtilities();
        Instant startDate = dateUtilities.createInstantFromDateTimeString(startDateString);
        Instant endDate = dateUtilities.createInstantFromDateTimeString(endDateString);
        List<Entry> entries = this.entryRepository.findByCreatedDateBetween(startDate, endDate);
//        MealBolus test = new MealBolus();
//        test.setAbsorptionTime(BigDecimal.ONE);
//        test.setCarbs(BigDecimal.ZERO);
//        test.setModifiedDate(Instant.now());
//        test.setCreatedBy("ghull");
//        this.mealBolusRepository.save(test);
//        List<MealBolus> mealBoluses = this.mealBolusRepository.findByCreatedBy("ghull");
        return entries;
    }

    public LinkedHashMap<Long, Integer> graphSeries(String startDateString, String endDateString){
        DateUtilities dateUtilities = new DateUtilities();
        LinkedHashMap<Long, Integer> seriesData = new LinkedHashMap<>();
        Instant startDate = dateUtilities.createInstantFromDateTimeString(startDateString);
        Instant endDate = dateUtilities.createInstantFromDateTimeString(endDateString);
        List<Entry> entries = this.entryRepository.findByCreatedDateBetween(startDate, endDate);
        entries.stream().collect(Collectors.toMap(Entry::getCreatedDateEpoch, Entry::getSgv));
        entries.stream().forEach(entry -> seriesData.put(entry.getCreatedDateEpoch(),entry.getSgv()));
        return seriesData;
    }

}
