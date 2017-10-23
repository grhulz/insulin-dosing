package info.insulindosing.model;

import info.insulindosing.EventType;
import java.math.BigDecimal;
import java.time.Instant;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author greghull
 */
@Document(collection = "treatments")
@TypeAlias("Correction Bolus")
public class CorrectionBolus extends Treatment {

    @Field("eventType")
    private String eventType = EventType.CORRECTION_BOLUS.toString();

    @Field("type")
    private String type = "normal";

    @Field("insulin")
    private double insulin;

    @Field("programmed")
    private double programmed = insulin;

    @Field("unabsorbed")
    private int unabsorbed;

    @Field("duration")
    private int duration;

    public CorrectionBolus() {
    }

    @PersistenceConstructor
    public CorrectionBolus(String type, double insulin, Double programmed, int unabsorbed, int duration, String loopCreatedDate, String loopModifiedDate, String loopEnteredBy, ObjectId id, Instant createdDate, Instant modifiedDate, String createdBy) {
        super(loopCreatedDate, loopModifiedDate, loopEnteredBy, id, createdDate, modifiedDate, createdBy);
        this.eventType = EventType.CORRECTION_BOLUS.toString();
        if (null != type) {
            this.type = type;
        }
        this.insulin = insulin;
        if (null != programmed) {
            this.programmed = programmed;
        }
        this.unabsorbed = unabsorbed;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("CorrectionBolus[type=%s, insulin='%s', programmed='%s', unabsorbed='%s', duration='%s']", getType(), getInsulin(), getProgrammed(), getUnabsorbed(), getDuration());
    }

    /**
     * @return the eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the insulin
     */
    public double getInsulin() {
        return insulin;
    }

    /**
     * @param insulin the insulin to set
     */
    public void setInsulin(double insulin) {
        this.insulin = insulin;
    }

    /**
     * @return the programmed
     */
    public double getProgrammed() {
        return programmed;
    }

    /**
     * @param programmed the programmed to set
     */
    public void setProgrammed(double programmed) {
        this.programmed = programmed;
    }

    /**
     * @return the unabsorbed
     */
    public int getUnabsorbed() {
        return unabsorbed;
    }

    /**
     * @param unabsorbed the unabsorbed to set
     */
    public void setUnabsorbed(int unabsorbed) {
        this.unabsorbed = unabsorbed;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

}
