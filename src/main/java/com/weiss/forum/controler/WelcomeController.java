package com.weiss.forum.controler;

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

    @RequestMapping("/")
    public String index(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "index");
	return "index";
    }

    @RequestMapping("/test")
    public String jspTest(Model model) {
	return "test/jsp-spring-boot";
    }
}
