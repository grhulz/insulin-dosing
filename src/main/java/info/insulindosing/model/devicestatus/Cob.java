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
@TypeAlias("Cob")
public class Cob {
    
    @Field("timestamp")
    private String loopModifiedDate = "";

    @Field("cob")
    private double cob;

    @CreatedDate
    @Field("createdDate")
    private Instant createdDate = Instant.now();

    public Cob() {
    }

    @PersistenceConstructor
    public Cob(String loopModifiedDate, Double cob, Instant createdDate) {
        if(null!=loopModifiedDate){
            this.loopModifiedDate = loopModifiedDate;
        }
        if(null!=cob){
            this.cob = cob;
        }
        if(null!=createdDate){
            this.createdDate = createdDate;
        }
    }

    public String getLoopModifiedDate() {
        return loopModifiedDate;
    }

    public void setLoopModifiedDate(String loopModifiedDate) {
        this.loopModifiedDate = loopModifiedDate;
    }

    public double getCob() {
        return cob;
    }

    public void setCob(double cob) {
        this.cob = cob;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
}
