package com.weiss.forum.controler;

import com.weiss.forum.logic.ContentController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Niklas
 */
@Controller
public class ProjectController {

    private static Logger LOGGER = Logger.getLogger(ProjectController.class);

    @Autowired
    private ContentController contentController;

    @RequestMapping("/project")
    public String project(ModelMap model) {
	LOGGER.info("/project is called");
	
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "project");
	model.addAttribute("content", this.contentController.getContents("project"));
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation("ger"));
	return "index";
    }

    @RequestMapping(name = "/project/add", method = RequestMethod.GET)
    public String add(ModelMap model) {
	LOGGER.info("/project/add is called GET");
	
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "edit/project");
	model.addAttribute("content", this.contentController.getContents("project"));
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation("ger"));
	return "index";
    }
}
