package info.insulindosing.service;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
import info.insulindosing.EventType;
import info.insulindosing.model.treatments.BGCheck;
import info.insulindosing.model.treatments.CorrectionBolus;
import info.insulindosing.model.devicestatus.LoopStatus;
import info.insulindosing.model.treatments.MealBolus;
import info.insulindosing.model.devicestatus.PumpStatus;
import info.insulindosing.model.entries.Entry;
import info.insulindosing.model.treatments.TempBasal;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import info.insulindosing.repository.BGCheckRepository;
import info.insulindosing.repository.CorrectionBolusRepository;
import info.insulindosing.repository.EntryRepository;
import info.insulindosing.repository.LoopStatusRepository;
import info.insulindosing.repository.MealBolusRepository;
import info.insulindosing.repository.PumpStatusRepository;
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
    private LoopStatusRepository loopStatusRepository;
    private PumpStatusRepository pumpStatusRepository;
    private EntryRepository entryRepository;

    private static final Logger logger = LogManager.getLogger(InitDataService.class);

    @Autowired
    public InitDataService(TreatmentRepository treatmentRepository, MealBolusRepository mealBolusRepository, BGCheckRepository bGCheckRepository, CorrectionBolusRepository correctionBolusRepository, TempBasalRepository tempBasalRepository, LoopStatusRepository loopStatusRepository, PumpStatusRepository pumpStatusRepository, EntryRepository entryRepository) {
        this.treatmentRepository = treatmentRepository;
        this.mealBolusRepository = mealBolusRepository;
        this.bGCheckRepository = bGCheckRepository;
        this.correctionBolusRepository = correctionBolusRepository;
        this.tempBasalRepository = tempBasalRepository;
        this.loopStatusRepository = loopStatusRepository;
        this.pumpStatusRepository = pumpStatusRepository;
        this.entryRepository = entryRepository;
    }

    public String initTreatmentData(String deviceName) {
        String message = "Init has failed";
        String enteredBy = "loop://" + deviceName;
        try {
            DateUtilities dateUtilities = new DateUtilities();
            List<MealBolus> mealBoluses = this.mealBolusRepository.findByLoopEnteredByAndEventType(enteredBy, EventType.MEAL_BOLUS.toString());
            mealBoluses.stream().forEach(mealBolus -> {
                mealBolus.setCreatedDate(dateUtilities.createInstantFromDateTimeString(mealBolus.getLoopCreatedDate()));
                mealBolus.setModifiedDate(Instant.now());
                mealBolus.setCreatedBy("Insulin Dosing");
            });
            this.mealBolusRepository.save(mealBoluses);

            List<BGCheck> bGChecks = this.bGCheckRepository.findByLoopEnteredByAndEventType(enteredBy, EventType.BG_CHECK.toString());
            bGChecks.stream().forEach(bGCheck -> {
                bGCheck.setCreatedDate(dateUtilities.createInstantFromDateTimeString(bGCheck.getLoopCreatedDate()));
                bGCheck.setModifiedDate(Instant.now());
                bGCheck.setCreatedBy("Insulin Dosing");
            });
            this.bGCheckRepository.save(bGChecks);

            List<CorrectionBolus> correctionBoluses = this.correctionBolusRepository.findByLoopEnteredByAndEventType(enteredBy, EventType.CORRECTION_BOLUS.toString());
            correctionBoluses.stream().forEach(correctionBolus -> {
                correctionBolus.setCreatedDate(dateUtilities.createInstantFromDateTimeString(correctionBolus.getLoopCreatedDate()));
                correctionBolus.setModifiedDate(Instant.now());
                correctionBolus.setCreatedBy("Insulin Dosing");
            });
            this.correctionBolusRepository.save(correctionBoluses);

            List<TempBasal> tempBasals = this.tempBasalRepository.findByLoopEnteredByAndEventType(enteredBy, EventType.TEMP_BASAL.toString());
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

    public String initStatusData(String loopName, String pumpId) {
        String message = "Status init has failed";
        try {
            DateUtilities dateUtilities = new DateUtilities();
            List<LoopStatus> loopStatuses = this.loopStatusRepository.findByName(loopName);
            loopStatuses.stream().forEach(loopStatus -> {
                loopStatus.setCreatedDate(dateUtilities.createInstantFromDateTimeString(loopStatus.getLoopCreatedDate()));
                loopStatus.setModifiedDate(Instant.now());
                loopStatus.setCreatedBy("Insulin Dosing");
                loopStatus.getLoop().setCreatedDate(dateUtilities.createInstantFromDateTimeString(loopStatus.getLoop().getLoopModifiedDate()));
                loopStatus.getLoop().getCob().setCreatedDate(dateUtilities.createInstantFromDateTimeString(loopStatus.getLoop().getCob().getLoopModifiedDate()));
                loopStatus.getLoop().getIob().setCreatedDate(dateUtilities.createInstantFromDateTimeString(loopStatus.getLoop().getIob().getLoopModifiedDate()));
                loopStatus.getLoop().getPredicted().setCreatedDate(dateUtilities.createInstantFromDateTimeString(loopStatus.getLoop().getPredicted().getLoopCreatedDate()));
            });
            this.loopStatusRepository.save(loopStatuses);

            List<PumpStatus> pumpStatuses = this.pumpStatusRepository.findByPumpId(pumpId);
            pumpStatuses.stream().forEach(pumpStatus -> {
                pumpStatus.setCreatedDate(dateUtilities.createInstantFromDateTimeString(pumpStatus.getLoopCreatedDate()));
                pumpStatus.setModifiedDate(Instant.now());
                pumpStatus.setCreatedBy("Insulin Dosing");
                pumpStatus.getPump().getIob().setCreatedDate(dateUtilities.createInstantFromDateTimeString(pumpStatus.getPump().getIob().getLoopModifiedDate()));
                pumpStatus.getUploader().setCreatedDate(dateUtilities.createInstantFromDateTimeString(pumpStatus.getUploader().getLoopModifiedDate()));
                pumpStatus.getRadioAdapter().setLastTunedDate(dateUtilities.createInstantFromDateTimeString(pumpStatus.getRadioAdapter().getLoopLastTuned()));
            });
            this.pumpStatusRepository.save(pumpStatuses);

            message = "Status Init Successful";

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return message;
    }

    public String initEntryData(String type) {
        String message = "Status init has failed";
        try {
            DateUtilities dateUtilities = new DateUtilities();
            logger.error("The type is " + type);
            List<Entry> entries = this.entryRepository.findByEntryType(type);
            entries.stream().forEach(entry -> {
                entry.setCreatedDate(dateUtilities.createInstantFromDateTimeString(entry.getLoopCreatedDate()));
                entry.setModifiedDate(Instant.now());
                entry.setCreatedBy("Insulin Dosing");
            });
            this.entryRepository.save(entries);

            message = "Status Init Successful";

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return message;
    }
}
