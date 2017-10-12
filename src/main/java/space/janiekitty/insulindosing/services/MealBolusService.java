package space.janiekitty.insulindosing.services;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import space.janiekitty.insulindosing.models.MealBolus;
import space.janiekitty.insulindosing.repositories.MealBolusRepository;

@Service
public class MealBolusService {
    private MealBolusRepository mealBolusRepository;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final Logger logger = LogManager.getLogger(MealBolusService.class);

    @Autowired
    public MealBolusService(MealBolusRepository mealBolusRepository) {
        this.mealBolusRepository = mealBolusRepository;
    }

    public List<MealBolus> getMealBolusesForDateRange(String startDateString, String endDateString){
        Instant startDate = createInstantFromDateTimeString(startDateString);
        Instant endDate = createInstantFromDateTimeString(endDateString);
        List<MealBolus> mealBoluses = this.mealBolusRepository.findByModifiedDateBetween(startDate, endDate);
        return mealBoluses;
    }

    private Instant createInstantFromDateTimeString(String dateString){
        
        Instant date = null;
        if(null!=dateString) {
            try {
                date = Instant.parse(dateString);
            }catch(DateTimeParseException pe){
                date = Instant.now();
                logger.error(pe.getMessage(),pe);
            }
        }else{
            date = Instant.now();
        }
        return date;
    }
}
