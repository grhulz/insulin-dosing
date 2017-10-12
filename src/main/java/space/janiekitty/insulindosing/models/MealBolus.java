package space.janiekitty.insulindosing.models;

import java.math.BigDecimal;
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

    @Field("foodType")
    private String foodType;
    @Field("carbs")
    private BigDecimal carbs;
    @Field("absorptionTime")
    private BigDecimal absorptionTime;

    public MealBolus() {}

    public MealBolus(String foodType, BigDecimal carbs, BigDecimal absorptionTime) {
        this.foodType = foodType;
        this.carbs = carbs;
        this.absorptionTime = absorptionTime;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("MealBolus[foodType=%s, carbs='%s', absorptionTime='%s']", getFoodType(), getCarbs(), getAbsorptionTime());
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
