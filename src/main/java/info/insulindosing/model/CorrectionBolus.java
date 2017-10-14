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
@TypeAlias("Correction Bolus")
public class CorrectionBolus {

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

    @Field("type")
    private String type;

    @Field("insulin")
    private BigDecimal insulin;

    @Field("programmed")
    private BigDecimal programmed;

    @Field("unabsorbed")
    private BigDecimal unabsorbed;

    @Field("duration")
    private BigDecimal duration;

    public CorrectionBolus() {}

    @PersistenceConstructor
    public CorrectionBolus(String type, BigDecimal insulin, BigDecimal programmed, BigDecimal unabsorbed, BigDecimal duration) {
        this.eventType = "Correction Bolus";
        this.type = type;
        this.insulin = insulin;
        this.programmed = programmed;
        this.unabsorbed = unabsorbed;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("CorrectionBolus[type=%s, insulin='%s', programmed='%s', unabsorbed='%s', duration='%s']", getType(), getInsulin(), getProgrammed(), getUnabsorbed(), getDuration());
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
    public BigDecimal getInsulin() {
        return insulin;
    }

    /**
     * @param insulin the insulin to set
     */
    public void setInsulin(BigDecimal insulin) {
        this.insulin = insulin;
    }

    /**
     * @return the programmed
     */
    public BigDecimal getProgrammed() {
        return programmed;
    }

    /**
     * @param programmed the programmed to set
     */
    public void setProgrammed(BigDecimal programmed) {
        this.programmed = programmed;
    }

    /**
     * @return the unabsorbed
     */
    public BigDecimal getUnabsorbed() {
        return unabsorbed;
    }

    /**
     * @param unabsorbed the unabsorbed to set
     */
    public void setUnabsorbed(BigDecimal unabsorbed) {
        this.unabsorbed = unabsorbed;
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
