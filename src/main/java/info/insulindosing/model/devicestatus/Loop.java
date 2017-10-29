package info.insulindosing.model.devicestatus;

import info.insulindosing.model.devicestatus.Iob;
import info.insulindosing.model.devicestatus.Cob;
import java.time.Instant;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
@Document(collection = "devicestatus")
@TypeAlias("Loop")
public class Loop {

    @Field("name")
    private String name = "";

    @Field("recommendedBolus")
    private double recommendedBolus;

    @Field("cob")
    private Cob cob = new Cob();

    @Field("version")
    private String version = "";

    @Field("timestamp")
    private String loopModifiedDate = "";

    @Field("iob")
    private Iob iob = new Iob();

    @Field("predicted")
    private Predicted predicted = new Predicted();

    @CreatedDate
    @Field("createdDate")
    private Instant createdDate = Instant.now();

    public Loop() {
    }

    @PersistenceConstructor
    public Loop(String name, Double recommendedBolus, Cob cob, String version, String loopModifiedDate, Iob iob, Predicted predicted, Instant createdDate) {

        if (null != name) {
            this.name = name;
        }
        if(null!=recommendedBolus){
            this.recommendedBolus = recommendedBolus;
        }
        if (null != cob) {
            this.cob = cob;
        }
        if (null != version) {
            this.version = version;
        }
        if (null != loopModifiedDate) {
            this.loopModifiedDate = loopModifiedDate;
        }
        if (null != iob) {
            this.iob = iob;
        }
        if (null != predicted) {
            this.predicted = predicted;
        }
        if (null != createdDate) {
            this.createdDate = createdDate;
        }
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRecommendedBolus() {
        return recommendedBolus;
    }

    public void setRecommendedBolus(double recommendedBolus) {
        this.recommendedBolus = recommendedBolus;
    }

    public Cob getCob() {
        return cob;
    }

    public void setCob(Cob cob) {
        this.cob = cob;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLoopModifiedDate() {
        return loopModifiedDate;
    }

    public void setLoopModifiedDate(String loopModifiedDate) {
        this.loopModifiedDate = loopModifiedDate;
    }

    public Iob getIob() {
        return iob;
    }

    public void setIob(Iob iob) {
        this.iob = iob;
    }

    public Predicted getPredicted() {
        return predicted;
    }

    public void setPredicted(Predicted predicted) {
        this.predicted = predicted;
    }

}
