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
@TypeAlias("Predicted")
public class Predicted {

    @Field("startDate")
    private String loopCreatedDate;

    @Field("values")
    private int[] values = {0};

    @CreatedDate
    @Field("createdDate")
    private Instant createdDate = Instant.now();

    public Predicted() {
    }

    @PersistenceConstructor
    public Predicted(String loopCreatedDate, int[] values, Instant createdDate) {
        if (null != loopCreatedDate) {
            this.loopCreatedDate = loopCreatedDate;
        }
        if (null != values) {
            this.values = values;
        }
        if (null != createdDate) {
            this.createdDate = createdDate;
        }
    }

    public String getLoopCreatedDate() {
        return loopCreatedDate;
    }

    public void setLoopCreatedDate(String loopCreatedDate) {
        this.loopCreatedDate = loopCreatedDate;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

}
