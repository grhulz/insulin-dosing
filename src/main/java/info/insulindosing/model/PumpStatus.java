package info.insulindosing.model;

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
@TypeAlias("Pump Status")
public class PumpStatus extends BaseEntity {

    @Field("device")
    private String device = "";

    @Field("pump")
    private Pump pump = new Pump();

    @Field("uploader")
    private Uploader uploader = new Uploader();

    @Field("radioAdapter")
    private RadioAdapter radioAdapter = new RadioAdapter();

    @Field("created_at")
    private String loopCreatedDate = "";

    public PumpStatus() {
    }

    @PersistenceConstructor
    public PumpStatus(String device, Pump pump, Uploader uploader, RadioAdapter radioAdapter, ObjectId id, Instant createdDate, Instant modifiedDate, String createdBy) {
        super(id, createdDate, modifiedDate, createdBy);
        if (null != device) {
            this.device = device;
        }
        if(null!=pump){
            this.pump = pump;
        }
        if(null!=uploader){
            this.uploader = uploader;
        }
        if(null!=radioAdapter){
            this.radioAdapter = radioAdapter;
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

    public Pump getPump() {
        return pump;
    }

    public void setPump(Pump pump) {
        this.pump = pump;
    }

    public Uploader getUploader() {
        return uploader;
    }

    public void setUploader(Uploader uploader) {
        this.uploader = uploader;
    }

    public RadioAdapter getRadioAdapter() {
        return radioAdapter;
    }

    public void setRadioAdapter(RadioAdapter radioAdapter) {
        this.radioAdapter = radioAdapter;
    }

    public String getLoopCreatedDate() {
        return loopCreatedDate;
    }

    public void setLoopCreatedDate(String loopCreatedDate) {
        this.loopCreatedDate = loopCreatedDate;
    }

}
