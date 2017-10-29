/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.model.devicestatus;

import java.time.Instant;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
@Document(collection = "devicestatus")
@TypeAlias("Radio Adapter")
public class RadioAdapter {

    @Field("hardware")
    private String hardware = "";

    @Field("name")
    private String name = "";

    @Field("lastTuned")
    private String loopLastTuned = "";

    @Field("lastTunedDate")
    private Instant lastTunedDate = Instant.now();

    @Field("RSSI")
    private int rssi;

    @Field("pumpRSSI")
    private int pumpRssi;

    @Field("frequency")
    private double frequency;

    @Field("firmwareVersion")
    private String firmwareVersion = "";

    public RadioAdapter() {
    }

    @PersistenceConstructor
    public RadioAdapter(String hardware, String name, String loopLastTuned, Instant lastTunedDate, Integer rssi, Integer pumpRssi, Double frequency, String firmwareVersion) {
        if(null!=hardware){
            this.hardware = hardware;
        }
        if(null!=name){
            this.name = name;
        }
        if(null!=loopLastTuned){
            this.loopLastTuned = loopLastTuned;
        }
        if(null!=lastTunedDate){
            this.lastTunedDate = lastTunedDate;
        }
        if(null!=rssi){
            this.rssi = rssi;
        }
        if(null!=pumpRssi){
            this.pumpRssi = pumpRssi;
        }
        if(null!=frequency){
            this.frequency = frequency;
        }
        if(null!=firmwareVersion){
            this.firmwareVersion = firmwareVersion;
        }
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoopLastTuned() {
        return loopLastTuned;
    }

    public void setLoopLastTuned(String loopLastTuned) {
        this.loopLastTuned = loopLastTuned;
    }

    public Instant getLastTunedDate() {
        return lastTunedDate;
    }

    public void setLastTunedDate(Instant lastTunedDate) {
        this.lastTunedDate = lastTunedDate;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getPumpRssi() {
        return pumpRssi;
    }

    public void setPumpRssi(int pumpRssi) {
        this.pumpRssi = pumpRssi;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

}
