package info.insulindosing.model;

import info.insulindosing.EventType;
import java.time.Instant;
import java.util.Objects;
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
@TypeAlias("Meal Bolus")
public class MealBolus extends Treatment {

    @Field("eventType")
    private String eventType = EventType.MEAL_BOLUS.toString();

    @Field("foodType")
    private String foodType = "";

    @Field("carbs")
    private int carbs;

    @Field("absorptionTime")
    private int absorptionTime = 180;

    public MealBolus() {
    }

    @PersistenceConstructor
    public MealBolus(String foodType, int carbs, Integer absorptionTime, String loopCreatedDate, String loopModifiedDate, String loopEnteredBy, ObjectId id, Instant createdDate, Instant modifiedDate, String createdBy) {
        super(loopCreatedDate, loopModifiedDate, loopEnteredBy, id, createdDate, modifiedDate, createdBy);
        this.eventType = EventType.MEAL_BOLUS.toString();
        if (null != foodType) {
            this.foodType = foodType;
        }
        this.carbs = carbs;
        if (null != absorptionTime) {
            this.absorptionTime = absorptionTime;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("MealBolus[foodType=%s, carbs='%s', absorptionTime='%s']", getFoodType(), getCarbs(), getAbsorptionTime());
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
    public int getCarbs() {
        return carbs;
    }

    /**
     * @param carbs the carbs to set
     */
    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    /**
     * @return the absorptionTime
     */
    public int getAbsorptionTime() {
        return absorptionTime;
    }

    /**
     * @param absorptionTime the absorptionTime to set
     */
    public void setAbsorptionTime(int absorptionTime) {
        this.absorptionTime = absorptionTime;
    }

}
