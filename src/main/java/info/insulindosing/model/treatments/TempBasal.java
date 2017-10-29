package info.insulindosing.model.treatments;

import info.insulindosing.EventType;
import java.math.BigDecimal;
import java.time.Instant;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author greghull
 */
@Document(collection = "treatments")
@TypeAlias("Temp Basal")
public class TempBasal extends Treatment {

    @Field("eventType")
    private String eventType = EventType.TEMP_BASAL.toString();

    @Field("temp")
    private String temp = "absolute";

    @Field("absolute")
    private double absolute;

    @Field("rate")
    private double rate;

    @Field("duration")
    private int duration;

    public TempBasal() {
    }

    @PersistenceConstructor
    public TempBasal(String eventType, String temp, double absolute, double rate, int duration, String loopCreatedDate, String loopModifiedDate, String loopEnteredBy, ObjectId id, Instant createdDate, Instant modifiedDate, String createdBy) {
        super(loopCreatedDate, loopModifiedDate, loopEnteredBy, id, createdDate, modifiedDate, createdBy);
        this.eventType = EventType.TEMP_BASAL.toString();
        if (null != temp) {
            this.temp = temp;
        }
        this.absolute = absolute;
        this.rate = rate;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("TempBasal[temp=%s, absolute='%s', rate='%s', duration='%s']", getTemp(), getAbsolute(), getRate(), getDuration());
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
     * @return the temp
     */
    public String getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(String temp) {
        this.temp = temp;
    }

    /**
     * @return the absolute
     */
    public double getAbsolute() {
        return absolute;
    }

    /**
     * @param absolute the absolute to set
     */
    public void setAbsolute(double absolute) {
        this.absolute = absolute;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
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
