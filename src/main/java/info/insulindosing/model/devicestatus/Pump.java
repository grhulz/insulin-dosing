package info.insulindosing.model.devicestatus;

import info.insulindosing.model.devicestatus.Iob;
import info.insulindosing.model.devicestatus.Battery;
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
@TypeAlias("Pump")
public class Pump {

    @Field("pumpID")
    private String pumpId = "";

    @Field("battery")
    private Battery battery = new Battery();

    @Field("reservoir")
    private double reservoir;

    @Field("iob")
    private Iob iob = new Iob();

    @Field("clock")
    private String loopClock = "";

    @CreatedDate
    @Field("createdDate")
    private Instant createdDate = Instant.now();

    public Pump() {
    }

    @PersistenceConstructor
    public Pump(String pumpId, Battery battery, Double reservoir, Iob iob, String loopClock, Instant createdDate) {
        if (null != pumpId) {
            this.pumpId = pumpId;
        }
        if (null != battery) {
            this.battery = battery;
        }
        if(null!=reservoir){
            this.reservoir = reservoir;
        }
        if (null != iob) {
            this.iob = iob;
        }
        if (null != loopClock) {
            this.loopClock = loopClock;
        }
        if (null != createdDate) {
            this.createdDate = createdDate;
        }
    }

    public String getPumpId() {
        return pumpId;
    }

    public void setPumpId(String pumpId) {
        this.pumpId = pumpId;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public double getReservoir() {
        return reservoir;
    }

    public void setReservoir(double reservoir) {
        this.reservoir = reservoir;
    }

    public Iob getIob() {
        return iob;
    }

    public void setIob(Iob iob) {
        this.iob = iob;
    }

    public String getLoopClock() {
        return loopClock;
    }

    public void setLoopClock(String loopClock) {
        this.loopClock = loopClock;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

}
