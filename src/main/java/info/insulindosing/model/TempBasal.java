package info.insulindosing.model;

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
public class TempBasal {

    @Id
    @Field("_id")
    private ObjectId id;    

    @CreatedDate
    @Field("created_at")
    private String createdDate;
 
    @LastModifiedDate
    @Field("timestamp")
    private Instant modifiedDate;

    @CreatedBy
    @Field("enteredBy")
    private String createdBy;

    @Field("eventType")
    private String eventType;

    @Field("temp")
    private String temp;

    @Field("absolute")
    private BigDecimal absolute;

    @Field("rate")
    private BigDecimal rate;

    @Field("duration")
    private BigDecimal duration;

    public TempBasal() {}

    @PersistenceConstructor
    public TempBasal(String temp, BigDecimal absolute, BigDecimal rate, BigDecimal duration) {
        this.eventType = "Temp Basal";
        this.temp = temp;
        this.absolute = absolute;
        this.rate = rate;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("TempBasal[temp=%s, absolute='%s', rate='%s', duration='%s']", getTemp(), getAbsolute(), getRate(), getDuration());
    }

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the modifiedDate
     */
    public Instant getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
    public BigDecimal getAbsolute() {
        return absolute;
    }

    /**
     * @param absolute the absolute to set
     */
    public void setAbsolute(BigDecimal absolute) {
        this.absolute = absolute;
    }

    /**
     * @return the rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * @return the duration
     */
    public BigDecimal getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

}
