/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.model;

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
@TypeAlias("Uploader")
public class Uploader {

    @Field("timestamp")
    private String loopModifiedDate = "";

    @Field("name")
    private String name = "";

    @Field("battery")
    private double battery;

    @CreatedDate
    @Field("createdDate")
    private Instant createdDate = Instant.now();

    public Uploader() {
    }

    @PersistenceConstructor
    public Uploader(String loopModifiedDate, String name, Double battery, Instant createdDate) {
        if(null!=loopModifiedDate){
            this.loopModifiedDate = loopModifiedDate;
        }
        if(null!=name){
            this.name = name;
        }
        if(null!=battery){
            this.battery = battery;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
}
