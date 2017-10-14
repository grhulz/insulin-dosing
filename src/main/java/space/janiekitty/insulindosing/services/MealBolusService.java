package space.janiekitty.insulindosing.services;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */

import java.math.BigDecimal;
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
import space.janiekitty.insulindosing.services.utilities.DateUtilities;

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
        DateUtilities dateUtilities = new DateUtilities();
        Instant startDate = dateUtilities.createInstantFromDateTimeString(startDateString);
        Instant endDate = dateUtilities.createInstantFromDateTimeString(endDateString);
        List<MealBolus> mealBoluses = this.mealBolusRepository.findByModifiedDateBetween(startDate, endDate);
        return mealBoluses;
    }
}
