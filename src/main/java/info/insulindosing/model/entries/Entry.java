package info.insulindosing.model.entries;

import info.insulindosing.model.BaseEntity;
import java.time.Instant;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author greghull
 */
@Document(collection = "entries")
@TypeAlias("Entry")
public class Entry extends BaseEntity {

    @Field("sgv")
    private int sgv;

    @Field("date")
    private double loopDate;

    @Field("dateString")
    private String loopCreatedDate;

    @Field("trend")
    private int trend;

    @Field("direction")
    private String direction;

    @Field("device")
    private String device;

    @Field("type")
    private String entryType;

    public Entry() {
    }

    @PersistenceConstructor
    public Entry(int sgv, double loopDate, String loopCreatedDate, int trend, String direction, String device, String entryType, ObjectId id, Instant createdDate, Instant modifiedDate, String createdBy) {
        super(id, createdDate, modifiedDate, createdBy);
        this.sgv = sgv;
        this.loopDate = loopDate;
        this.loopCreatedDate = loopCreatedDate;
        this.trend = trend;
        this.direction = direction;
        this.device = device;
        this.entryType = entryType;
    }

    @Override
    public String toString() {
        return String.format("Treatment[id=%s, createdBy='%s', createdDate='%s', modifiedDate='%s', loopCreatedDate='%s']", getId(), getCreatedBy(), getCreatedDate().toString(), getModifiedDate().toString(), getLoopCreatedDate());
    }

    public int getSgv() {
        return sgv;
    }

    public void setSgv(int sgv) {
        this.sgv = sgv;
    }

    public double getLoopDate() {
        return loopDate;
    }

    public void setLoopDate(double loopDate) {
        this.loopDate = loopDate;
    }

    public String getLoopCreatedDate() {
        return loopCreatedDate;
    }

    public void setLoopCreatedDate(String loopCreatedDate) {
        this.loopCreatedDate = loopCreatedDate;
    }

    public int getTrend() {
        return trend;
    }

    public void setTrend(int trend) {
        this.trend = trend;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setType(String entryType) {
        this.entryType = entryType;
    }


    public long getCreatedDateEpoch(){
        return this.createdDate.toEpochMilli();
    }
}
