package space.janiekitty.insulindosing.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author greghull
 */
@Document(collection = "treatments")
public class Treatment extends BaseEntity {

    @Field("_class")
    protected String eventType;

    public Treatment() {}

    public Treatment(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return String.format("Treatment[id=%s, createdBy='%s', createdDate='%s', modifiedDate='%s', eventType='%s']", getId(), getCreatedBy(), getCreatedDate(), getModifiedDate(), getEventType());
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

}
