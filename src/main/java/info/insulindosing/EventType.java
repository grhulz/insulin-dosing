/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.insulindosing;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public enum EventType {
    MEAL_BOLUS("Meal Bolus"),
    BG_CHECK("BG Check"),
    TEMP_BASAL("Temp Basal"),
    CORRECTION_BOLUS("Correction Bolus")
    ;

    private final String text;

    /**
     * @param text
     */
    private EventType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }    
}
