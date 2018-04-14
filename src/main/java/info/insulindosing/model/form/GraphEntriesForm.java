/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.model.form;

import info.insulindosing.model.entries.Entry;
import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public class GraphEntriesForm {
private String startDate;
private String endDate;
private List<Entry> entries;
private Map<Long, Integer> series;

    public Map<Long, Integer> getSeries() {
        return series;
    }

    public void setSeries(Map<Long, Integer> series) {
        this.series = series;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the mealBoluses
     */
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     * @param mealBoluses the mealBoluses to set
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
    
}
