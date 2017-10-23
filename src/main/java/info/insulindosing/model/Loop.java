package info.insulindosing.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author greghull
 */
@Document(collection = "devicestatus")
public class Loop extends BaseEntity {

    @Field("eventType")
    protected String eventType;

    @Field("created_at")
    protected String loopCreatedDate;

    @Field("timeStamp")
    protected String loopModifiedDate;

    public Loop() {}

    public Loop(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return String.format("Treatment[id=%s, createdBy='%s', createdDate='%s', modifiedDate='%s', eventType='%s', loopCreatedDate='%s', loopModifiedDate='%s']", getId(), getCreatedBy(), getCreatedDate().toString(), getModifiedDate().toString(), getEventType(), getLoopCreatedDate(), getLoopModifiedDate());
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
     * @return the loopCreatedDate
     */
    public String getLoopCreatedDate() {
        return loopCreatedDate;
    }

    /**
     * @param loopCreatedDate the loopCreatedDate to set
     */
    public void setLoopCreatedDate(String loopCreatedDate) {
        this.loopCreatedDate = loopCreatedDate;
    }

    /**
     * @return the loopModifiedDate
     */
    public String getLoopModifiedDate() {
        return loopModifiedDate;
    }

    /**
     * @param loopModifiedDate the loopModifiedDate to set
     */
    public void setLoopModifiedDate(String loopModifiedDate) {
        this.loopModifiedDate = loopModifiedDate;
    }

}
