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
import space.janiekitty.insulindosing.models.Treatment;
import space.janiekitty.insulindosing.repositories.TreatmentRepository;
import space.janiekitty.insulindosing.services.utilities.DateUtilities;

@Service
public class TreatmentService {
    private TreatmentRepository treatmentRepository;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final Logger logger = LogManager.getLogger(TreatmentService.class);

    @Autowired
    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    public List<Treatment> getTreatmentsForDateRange(String startDateString, String endDateString){
        DateUtilities dateUtilities = new DateUtilities();
        Instant startDate = dateUtilities.createInstantFromDateTimeString(startDateString);
        Instant endDate = dateUtilities.createInstantFromDateTimeString(endDateString);
        List<Treatment> treatments = this.treatmentRepository.findByModifiedDateBetween(startDate, endDate);
        return treatments;
    }

}
