package info.insulindosing.model;

import java.io.Serializable;
import java.time.Instant;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

public abstract class BaseEntity implements Serializable {

    @Id
    protected ObjectId id;

    @CreatedDate
    @Field("createdDate")
    protected Instant createdDate = Instant.now();

    @LastModifiedDate
    @Field("lastModifiedDate")
    protected Instant modifiedDate = Instant.now();

    @CreatedBy
    @Field("createdBy")
    protected String createdBy = "insulin-dosing";

    public BaseEntity() {
    }

    @PersistenceConstructor
    public BaseEntity(ObjectId id, Instant createdDate, Instant modifiedDate, String createdBy) {
        this.id = id;
        if (null != createdDate) {
            this.createdDate = createdDate;
        }
        if (null != modifiedDate) {
            this.modifiedDate = modifiedDate;
        }
        if (null != createdBy) {
            this.createdBy = createdBy;
        }
    }

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return the createdDate
     */
    public Instant getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the modifiedDate
     */
    public Instant getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
