package com.weiss.forum.controler;

import com.weiss.forum.logic.ContentController;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Niklas
 */
@Controller
public class CrewController {

    @Autowired
    private ContentController contentController;

    @RequestMapping("/crew")
    public String crew(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "crew");
	model.addAttribute("content", this.contentController.getContents("crew"));
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation("ger"));
	return "index";
    }

    @RequestMapping(value = "/crew/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String edit(ModelMap model, @PathVariable BigInteger id) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "crewEdit");
	model.addAttribute("content", this.contentController.getContents("crew"));
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation("ger"));
	return "index";
    }

    @RequestMapping(value = "/crew/add", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String addGet(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "crewAdd");
	model.addAttribute("content", this.contentController.getContents("crew"));
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation("ger"));
	return "index";
    }

    @RequestMapping(value = "/crew/add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String addPost(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "crewAdd");
	model.addAttribute("content", this.contentController.getContents("crew"));
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation("ger"));
	return "index";
    }
}
