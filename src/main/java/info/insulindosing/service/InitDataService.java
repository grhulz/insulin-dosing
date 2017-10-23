package info.insulindosing.service;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
import info.insulindosing.EventType;
import info.insulindosing.model.BGCheck;
import info.insulindosing.model.CorrectionBolus;
import info.insulindosing.model.MealBolus;
import info.insulindosing.model.TempBasal;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import info.insulindosing.model.Treatment;
import info.insulindosing.repository.BGCheckRepository;
import info.insulindosing.repository.CorrectionBolusRepository;
import info.insulindosing.repository.MealBolusRepository;
import info.insulindosing.repository.TempBasalRepository;
import info.insulindosing.repository.TreatmentRepository;
import space.janiekitty.insulindosing.service.utility.DateUtilities;

@Service
public class InitDataService {

    private TreatmentRepository treatmentRepository;
    private MealBolusRepository mealBolusRepository;
    private BGCheckRepository bGCheckRepository;
    private CorrectionBolusRepository correctionBolusRepository;
    private TempBasalRepository tempBasalRepository;

    private static final Logger logger = LogManager.getLogger(InitDataService.class);

    @Autowired
    public InitDataService(TreatmentRepository treatmentRepository, MealBolusRepository mealBolusRepository, BGCheckRepository bGCheckRepository, CorrectionBolusRepository correctionBolusRepository, TempBasalRepository tempBasalRepository) {
        this.treatmentRepository = treatmentRepository;
        this.mealBolusRepository = mealBolusRepository;
        this.bGCheckRepository = bGCheckRepository;
        this.correctionBolusRepository = correctionBolusRepository;
        this.tempBasalRepository = tempBasalRepository;
    }

    public List<Treatment> getTreatmentsForDateRange(String startDateString, String endDateString) {
        DateUtilities dateUtilities = new DateUtilities();
        Instant startDate = dateUtilities.createInstantFromDateTimeString(startDateString);
        Instant endDate = dateUtilities.createInstantFromDateTimeString(endDateString);
        List<Treatment> treatments = this.treatmentRepository.findByModifiedDateBetween(startDate, endDate);
        return treatments;
    }

    public String initTreatmentData() {
        String message = "Init has failed";
        try {
            DateUtilities dateUtilities = new DateUtilities();
            List<MealBolus> mealBoluses = this.mealBolusRepository.findByLoopEnteredByAndEventType("loop://Greg Hull’s iPod", EventType.MEAL_BOLUS.toString());
            mealBoluses.stream().forEach(mealBolus -> {
                mealBolus.setCreatedDate(dateUtilities.createInstantFromDateTimeString(mealBolus.getLoopCreatedDate()));
                mealBolus.setModifiedDate(Instant.now());
                mealBolus.setCreatedBy("Insulin Dosing");
            });
            this.mealBolusRepository.save(mealBoluses);

            List<BGCheck> bGChecks = this.bGCheckRepository.findByLoopEnteredByAndEventType("loop://Greg Hull’s iPod", EventType.BG_CHECK.toString());
            bGChecks.stream().forEach(bGCheck -> {
                bGCheck.setCreatedDate(dateUtilities.createInstantFromDateTimeString(bGCheck.getLoopCreatedDate()));
                bGCheck.setModifiedDate(Instant.now());
                bGCheck.setCreatedBy("Insulin Dosing");
            });
            this.bGCheckRepository.save(bGChecks);

            List<CorrectionBolus> correctionBoluses = this.correctionBolusRepository.findByLoopEnteredByAndEventType("loop://Greg Hull’s iPod", EventType.CORRECTION_BOLUS.toString());
            correctionBoluses.stream().forEach(correctionBolus -> {
                correctionBolus.setCreatedDate(dateUtilities.createInstantFromDateTimeString(correctionBolus.getLoopCreatedDate()));
                correctionBolus.setModifiedDate(Instant.now());
                correctionBolus.setCreatedBy("Insulin Dosing");
            });
            this.correctionBolusRepository.save(correctionBoluses);

            List<TempBasal> tempBasals = this.tempBasalRepository.findByLoopEnteredByAndEventType("loop://Greg Hull’s iPod", EventType.TEMP_BASAL.toString());
            tempBasals.stream().forEach(tempBasal -> {
                tempBasal.setCreatedDate(dateUtilities.createInstantFromDateTimeString(tempBasal.getLoopCreatedDate()));
                tempBasal.setModifiedDate(Instant.now());
                tempBasal.setCreatedBy("Insulin Dosing");
            });
            this.tempBasalRepository.save(tempBasals);

            message = "Success";

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return message;
    }

}
