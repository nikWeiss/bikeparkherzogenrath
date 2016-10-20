package com.weiss.forum.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niklas
 */
@Controller
@RequestMapping("/dates")
public class DatesController {

    @RequestMapping("/")
    public String dates(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "dates");
	return "index";
    }
}
