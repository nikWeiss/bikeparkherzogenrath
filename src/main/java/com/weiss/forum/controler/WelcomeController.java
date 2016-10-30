package com.weiss.forum.controler;

import com.weiss.forum.logic.ContentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niklas
 */
@Controller
public class WelcomeController {

    @Autowired
    private ContentController contentController;

    @RequestMapping("/")
    @PreAuthorize("permitAll()")
    public String index(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "index");
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation("ger"));
	return "index";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('USER_ADMIN')")
    public String admin(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath Admin");
	model.addAttribute("site", "index");
	model.addAttribute("leftNavigation", this.contentController.getAdminLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getAdminRightNaviation("ger"));
	return "index";
    }

    @RequestMapping("/test")
    public String jspTest(Model model) {
	return "test/jsp-spring-boot";
    }
}
