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
import space.janiekitty.insulindosing.models.forms.MealBolusForm;
import space.janiekitty.insulindosing.services.MealBolusService;

@Controller
public class MealBolusController {

    private static final Logger logger = LogManager.getLogger(MealBolusController.class);
    
    @Autowired
    private MealBolusService mealBolusService;

    @GetMapping("/mealboluses")
    public String mealBolusesForm(Model model) {
        model.addAttribute("mealBolusForm", new MealBolusForm());
        return "meal-boluses";
    }

    @PostMapping("/mealboluses")
    public String submitDateRange(@ModelAttribute MealBolusForm mealBolusForm){
        logger.debug("The start date is " + mealBolusForm.getStartDate() + " and the end date is " + mealBolusForm.getEndDate());
        List<MealBolus> mealBoluses = this.mealBolusService.getMealBolusesForDateRange(mealBolusForm.getStartDate(), mealBolusForm.getEndDate());
        mealBolusForm.setMealBoluses(mealBoluses);
        return "meal-boluses";
    }
}
