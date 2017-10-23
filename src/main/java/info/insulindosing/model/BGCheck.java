package info.insulindosing.model;

import info.insulindosing.EventType;
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
@TypeAlias("BG Check")
public class BGCheck extends Treatment {

    @Field("eventType")
    private String eventType = EventType.BG_CHECK.toString();

    @Field("glucose")
    private int glucose;

    @Field("glucoseType")
    private String glucoseType = "Meter";

    @Field("units")
    private String units = "mg/dL";

    public BGCheck() {
    }

    @PersistenceConstructor
    public BGCheck(int glucose, String glucoseType, String units, String loopCreatedDate, String loopModifiedDate, String loopEnteredBy, ObjectId id, Instant createdDate, Instant modifiedDate, String createdBy) {
        super(loopCreatedDate, loopModifiedDate, loopEnteredBy, id, createdDate, modifiedDate, createdBy);
        this.eventType = EventType.BG_CHECK.toString();
        this.glucose = glucose;
        if (null != glucoseType) {
            this.glucoseType = glucoseType;
        }
        if (null != glucoseType) {
            this.units = units;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("BGCheck[eventType=%s, glucose='%s', glucoseType='%s', units='%s']", getEventType(), getGlucose(), getGlucoseType(), getUnits());
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
     * @return the glucose
     */
    public int getGlucose() {
        return glucose;
    }

    /**
     * @param glucose the glucose to set
     */
    public void setGlucose(int glucose) {
        this.glucose = glucose;
    }

    /**
     * @return the glucoseType
     */
    public String getGlucoseType() {
        return glucoseType;
    }

    /**
     * @param glucoseType the glucoseType to set
     */
    public void setGlucoseType(String glucoseType) {
        this.glucoseType = glucoseType;
    }

    /**
     * @return the units
     */
    public String getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(String units) {
        this.units = units;
    }

}
