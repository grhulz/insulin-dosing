/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing.model.form;

import java.util.List;
import info.insulindosing.model.MealBolus;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public class MealBolusForm {
private String startDate;
private String endDate;
private List<MealBolus> mealBoluses;

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
    public List<MealBolus> getMealBoluses() {
        return mealBoluses;
    }

    /**
     * @param mealBoluses the mealBoluses to set
     */
    public void setMealBoluses(List<MealBolus> mealBoluses) {
        this.mealBoluses = mealBoluses;
    }
    
}
