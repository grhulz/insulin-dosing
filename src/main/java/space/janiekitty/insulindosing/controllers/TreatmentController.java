package space.janiekitty.insulindosing.controllers;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import space.janiekitty.insulindosing.models.MealBolus;
import space.janiekitty.insulindosing.models.Treatment;
import space.janiekitty.insulindosing.models.forms.TreatmentForm;
import space.janiekitty.insulindosing.services.MealBolusService;
import space.janiekitty.insulindosing.services.TreatmentService;

@Controller
public class TreatmentController {

    private static final Logger logger = LogManager.getLogger(TreatmentController.class);
    
    @Autowired
    private TreatmentService treatmentService;

    @GetMapping("/treatments")
    public String treatmentForm(Model model) {
        model.addAttribute("treatmentForm", new TreatmentForm());
        return "treatments";
    }

    @PostMapping("/treatments")
    public String submitDateRange(@ModelAttribute TreatmentForm treatmentForm){
        logger.debug("The start date is " + treatmentForm.getStartDate() + " and the end date is " + treatmentForm.getEndDate());
        List<Treatment> treatments = this.treatmentService.getTreatmentsForDateRange(treatmentForm.getStartDate(), treatmentForm.getEndDate());
        treatmentForm.setTreatments(treatments);
        return "treatments";
    }
}
