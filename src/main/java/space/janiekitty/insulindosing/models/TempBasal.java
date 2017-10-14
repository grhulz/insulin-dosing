package space.janiekitty.insulindosing.models;

import java.math.BigDecimal;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author greghull
 */
@TypeAlias("Temp Basal")
public class TempBasal extends Treatment {

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
