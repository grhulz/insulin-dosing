package info.insulindosing.model.treatments;

import info.insulindosing.model.BaseEntity;
import java.time.Instant;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author greghull
 */
@Document(collection = "treatments")
public class Treatment extends BaseEntity {

    @Field("created_at")
    protected String loopCreatedDate = "";

    @Field("timestamp")
    protected String loopModifiedDate = "";

    @Field("enteredBy")
    protected String loopEnteredBy = "loop";

    public Treatment() {
    }

    @PersistenceConstructor
    public Treatment(String loopCreatedDate, String loopModifiedDate, String loopEnteredBy, ObjectId id, Instant createdDate, Instant modifiedDate, String createdBy) {
        super(id, createdDate, modifiedDate, createdBy);
        if (null != loopCreatedDate) {
            this.loopCreatedDate = loopCreatedDate;
        }
        if (null != loopModifiedDate) {
            this.loopModifiedDate = loopModifiedDate;
        }
        if (null != loopEnteredBy) {
            this.loopEnteredBy = loopEnteredBy;
        }
    }

    @Override
    public String toString() {
        return String.format("Treatment[id=%s, createdBy='%s', createdDate='%s', modifiedDate='%s', loopCreatedDate='%s', loopModifiedDate='%s']", getId(), getCreatedBy(), getCreatedDate().toString(), getModifiedDate().toString(), getLoopCreatedDate(), getLoopModifiedDate());
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
