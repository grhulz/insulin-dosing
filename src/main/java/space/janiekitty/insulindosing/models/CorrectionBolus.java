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
@TypeAlias("Correction Bolus")
public class CorrectionBolus extends Treatment {

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

    public CorrectionBolus(String type, BigDecimal insulin, BigDecimal programmed, BigDecimal unabsorbed, BigDecimal duration) {
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
