package info.insulindosing.model.devicestatus;

import info.insulindosing.model.BaseEntity;
import info.insulindosing.model.devicestatus.Loop;
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
@Document(collection = "devicestatus")
@TypeAlias("Loop Status")
public class LoopStatus extends BaseEntity {

    @Field("device")
    private String device = "";

    @Field("loop")
    private Loop loop = new Loop();

    @Field("created_at")
    private String loopCreatedDate = "";

    public LoopStatus() {
    }

    @PersistenceConstructor
    public LoopStatus(String device, Loop loop, String loopCreatedDate, ObjectId id, Instant createdDate, Instant modifiedDate, String createdBy) {
        super(id, createdDate, modifiedDate, createdBy);

        if (null != device) {
            this.device = device;
        }
        if (null != loop) {
            this.loop = loop;
        }
        if (null != loopCreatedDate) {
            this.loopCreatedDate = loopCreatedDate;
        }
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Loop getLoop() {
        return loop;
    }

    public void setLoop(Loop loop) {
        this.loop = loop;
    }

    public String getLoopCreatedDate() {
        return loopCreatedDate;
    }

    public void setLoopCreatedDate(String loopCreatedDate) {
        this.loopCreatedDate = loopCreatedDate;
    }

}
