package info.insulindosing.controller;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
    
import info.insulindosing.model.form.InitDevicesForm;
import info.insulindosing.model.form.InitEntriesForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import info.insulindosing.model.form.InitTreatmentForm;
import info.insulindosing.service.InitDataService;

@Controller
public class InitializationController {

    private static final Logger logger = LogManager.getLogger(InitializationController.class);
    
    @Autowired
    private InitDataService initDataService;

    @GetMapping("/init/treatments")
    public String initTreatmentForm(Model model) {
        model.addAttribute("initTreatmentForm", new InitTreatmentForm());
        return "init-treatments";
    }

    @PostMapping("/init/treatments")
    public String initTreatmentData(@ModelAttribute InitTreatmentForm initTreatmentForm){
        String message = this.initDataService.initTreatmentData(initTreatmentForm.getDeviceName());
        logger.debug("The message is " + message);
        initTreatmentForm.setMessage(message);
        return "init-treatments";
    }
    
    @GetMapping("/init/devices")
    public String initDeviceForm(Model model) {
        model.addAttribute("initDevicesForm", new InitDevicesForm());
        return "init-devices";
    }

    @PostMapping("/init/devices")
    public String initDeviceData(@ModelAttribute InitDevicesForm initDevicesForm){
        String message = this.initDataService.initStatusData(initDevicesForm.getAppName(), initDevicesForm.getPumpId());
        logger.debug("The message is " + message);
        initDevicesForm.setMessage(message);
        return "init-devices";
    }

    @GetMapping("/init/entries")
    public String initEntryForm(Model model) {
        model.addAttribute("initEntriesForm", new InitEntriesForm());
        return "init-entries";
    }

    @PostMapping("/init/entries")
    public String initEntryData(@ModelAttribute InitEntriesForm initEntriesForm){
        String message = this.initDataService.initEntryData(initEntriesForm.getEntryType());
        logger.debug("The message is " + message);
        initEntriesForm.setMessage(message);
        return "init-entries";
    }
}
