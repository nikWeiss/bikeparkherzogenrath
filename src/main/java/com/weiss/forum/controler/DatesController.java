package com.weiss.forum.controler;

import com.weiss.forum.logic.ContentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niklas
 */
@Controller
public class DatesController extends MyController {

    @RequestMapping("/dates")
    public String dates(ModelMap model) {
	this.contentController.setHeaders(model, "Bikepark Herzogenrath", "dates");
	model.addAttribute("content", this.contentController.getContents("dates"));
	this.contentController.setNavigation(model);
	return "index";
    }
}
