package info.insulindosing.controller;

/**
 *
 * @author Greg Hull grhulz@gmail.com
 */
    
import info.insulindosing.model.form.GraphEntriesForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import info.insulindosing.service.GraphService;

@Controller
public class GraphController {

    private static final Logger logger = LogManager.getLogger(GraphController.class);
    
    @Autowired
    private GraphService graphService;

    @GetMapping("/graph/entries")
    public String graphEntriesForm(Model model) {
        model.addAttribute("graphEntriesForm", new GraphEntriesForm());
        return "entries-graph";
    }

    @PostMapping("/graph/entries")
    public String graphEntries(@ModelAttribute GraphEntriesForm graphEntriesForm){
        graphEntriesForm.setEntries(this.graphService.graphEntries(graphEntriesForm.getStartDate(), graphEntriesForm.getEndDate()));
        graphEntriesForm.setSeries(this.graphService.graphSeries(graphEntriesForm.getStartDate(), graphEntriesForm.getEndDate()));
        return "entries-graph";
    }
    
//    @GetMapping("/init/devices")
//    public String initDeviceForm(Model model) {
//        model.addAttribute("initDevicesForm", new InitDevicesForm());
//        return "init-devices";
//    }
//
//    @PostMapping("/init/devices")
//    public String initDeviceData(@ModelAttribute InitDevicesForm initDevicesForm){
//        String message = this.initDataService.initStatusData(initDevicesForm.getAppName(), initDevicesForm.getPumpId());
//        logger.debug("The message is " + message);
//        initDevicesForm.setMessage(message);
//        return "init-devices";
//    }
//
//    @GetMapping("/init/entries")
//    public String initEntryForm(Model model) {
//        model.addAttribute("initEntriesForm", new InitEntriesForm());
//        return "init-entries";
//    }
//
//    @PostMapping("/init/entries")
//    public String initEntryData(@ModelAttribute InitEntriesForm initEntriesForm){
//        String message = this.initDataService.initEntryData(initEntriesForm.getEntryType());
//        logger.debug("The message is " + message);
//        initEntriesForm.setMessage(message);
//        return "init-entries";
//    }
}
