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
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping("/")
    public String project(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "project");
	return "index";
    }
}
