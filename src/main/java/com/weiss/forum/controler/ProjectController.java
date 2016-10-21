package com.weiss.forum.controler;

import com.weiss.forum.logic.ContentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niklas
 */
@Controller
public class ProjectController {

    @Autowired
    private ContentController contentController;

    @RequestMapping("/project")
    public String project(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "project");
	model.addAttribute("content", this.contentController.getContents("project"));
	return "index";
    }
}
