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
public class DatesController {

    @Autowired
    private ContentController contentController;

    @RequestMapping("/dates")
    public String dates(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "dates");
	model.addAttribute("content", this.contentController.getContents("dates"));
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation());
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation());
	return "index";
    }
}
