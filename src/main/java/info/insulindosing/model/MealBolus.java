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
@TypeAlias("Meal Bolus")
public class MealBolus {

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

    @Field("foodType")
    private String foodType;

    @Field("carbs")
    private BigDecimal carbs;

    @Field("absorptionTime")
    private BigDecimal absorptionTime;

    public MealBolus() {}

    @PersistenceConstructor
    public MealBolus(String foodType, BigDecimal carbs, BigDecimal absorptionTime) {
        this.eventType = "Meal Bolus";
        this.foodType = foodType;
        this.carbs = carbs;
        this.absorptionTime = absorptionTime;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("MealBolus[foodType=%s, carbs='%s', absorptionTime='%s']", getFoodType(), getCarbs(), getAbsorptionTime());
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
     * @return the foodType
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     * @param foodType the foodType to set
     */
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    /**
     * @return the carbs
     */
    public BigDecimal getCarbs() {
        return carbs;
    }

    /**
     * @param carbs the carbs to set
     */
    public void setCarbs(BigDecimal carbs) {
        this.carbs = carbs;
    }

    /**
     * @return the absorptionTime
     */
    public BigDecimal getAbsorptionTime() {
        return absorptionTime;
    }

    /**
     * @param absorptionTime the absorptionTime to set
     */
    public void setAbsorptionTime(BigDecimal absorptionTime) {
        this.absorptionTime = absorptionTime;
    }

}
