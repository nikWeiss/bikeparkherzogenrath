package com.weiss.forum.controler;

import com.weiss.forum.db.repository.CrewRepository;
import com.weiss.forum.logic.ContentController;
import com.weiss.forum.logic.CrewContent;
import java.math.BigInteger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Niklas
 */
@Controller
public class CrewController {

    private static Logger LOGGER = Logger.getLogger(CrewController.class);

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private ContentController contentController;

    @RequestMapping("/crew")
    public String crew(ModelMap model) {
	LOGGER.info("/crew is called");

	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "crew");
	model.addAttribute("content", this.contentController.getContents("crew"));
	this.contentController.setNavigation(model);
	return "index";
    }

    @RequestMapping(value = "/crew/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String edit(ModelMap model, @PathVariable BigInteger id) {
	LOGGER.info("/crew/edit/" + id + " is called");

	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "edit/crew");
	model.addAttribute("content", this.contentController.getContents("crew"));
	this.contentController.setNavigation(model);
	model.addAttribute("crew", this.crewRepository.findOne(id));
	return "index";
    }

    @RequestMapping(value = "/crew/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(ModelMap model, @PathVariable BigInteger id) {
	LOGGER.info("/crew/delete/" + id + " is called");

	this.crewRepository.delete(id);
	return "redirect:/crew";
    }

    @RequestMapping(value = "/crew/add", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String addGet(ModelMap model) {
	LOGGER.info("/crew/add/ is called GET");

	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "edit/crew");
	model.addAttribute("content", this.contentController.getContents("crew"));
	this.contentController.setNavigation(model);
	model.addAttribute("crew", new CrewContent());
	return "index";
    }

    @RequestMapping(value = "/crew/add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String addPost(ModelMap model, @ModelAttribute("crew") CrewContent crew) {
	LOGGER.info("/crew/add/ is called POST");

	this.crewRepository.save(crew);
	return "redirect:/crew";
    }
}
