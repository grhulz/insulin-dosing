/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.janiekitty.insulindosing.service.utility;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
public class DateUtilities {
    
    private static final Logger logger = LogManager.getLogger(DateUtilities.class);
    
        public Instant createInstantFromDateTimeString(String dateString){
        
        Instant date = null;
        if(null!=dateString) {
            try {
                date = Instant.parse(dateString);
            }catch(DateTimeParseException pe){
                date = Instant.now();
                logger.error(pe.getMessage(),pe);
            }
        }else{
            date = Instant.now();
        }
        return date;
    }

}
