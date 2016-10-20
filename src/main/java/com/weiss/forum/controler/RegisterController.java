package com.weiss.forum.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niklas
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping("/")
    public String register(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "register");
	return "index";
    }
}
