package com.weiss.forum.controler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niklas
 */
@Controller
public class WelcomeController extends MyController {

    @RequestMapping("/")
    public String index(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "index");
	model.addAttribute("content", this.contentController.getContents("index"));
	this.contentController.setNavigation(model);
	return "index";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath Admin");
	model.addAttribute("site", "index");
	model.addAttribute("content", this.contentController.getContents("index"));
	this.contentController.setNavigation(model);
	return "index";
    }
}
