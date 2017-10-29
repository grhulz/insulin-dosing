/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.model.devicestatus;

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
@TypeAlias("Iob")
public class Iob {

    @Field("timestamp")
    private String loopModifiedDate;

    @Field("iob")
    private double iob;

    @CreatedDate
    @Field("createdDate")
    private Instant createdDate = Instant.now();

    public Iob() {
    }

    @PersistenceConstructor
    public Iob(String loopModifiedDate, Double iob, Instant createdDate) {
        if (null != loopModifiedDate) {
            this.loopModifiedDate = loopModifiedDate;
        }
        if(null!=iob){
            this.iob = iob;
        }
        if (null != createdDate) {
            this.createdDate = createdDate;
        }
    }

    public String getLoopModifiedDate() {
        return loopModifiedDate;
    }

    public void setLoopModifiedDate(String loopModifiedDate) {
        this.loopModifiedDate = loopModifiedDate;
    }

    public double getIob() {
        return iob;
    }

    public void setIob(double iob) {
        this.iob = iob;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

}
