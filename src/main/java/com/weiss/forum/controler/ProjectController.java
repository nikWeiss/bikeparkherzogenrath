package com.weiss.forum.controler;

import com.weiss.forum.db.repository.ProjectRepository;
import com.weiss.forum.logic.ContentController;
import com.weiss.forum.logic.ProjectContent;
import java.math.BigInteger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Niklas
 */
@Controller
public class ProjectController {

    private static Logger LOGGER = Logger.getLogger(ProjectController.class);

    @Autowired
    private ContentController contentController;

    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping("/project")
    public ModelAndView redirectProject(ModelMap model) {
	return new ModelAndView("redirect:/project/1", model);
    }

    @RequestMapping("/project/{pageNumber}")
    public String project(@PathVariable Integer pageNumber, ModelMap model) {
	LOGGER.info("/project is called");

	Page<ProjectContent> page = this.getProjectContent(pageNumber);
	int current = page.getNumber() + 1;
	int begin = Math.max(1, current - 5);
	int end = Math.min(begin + 10, page.getTotalPages());

	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "project");
	model.addAttribute("content", page);
	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation());
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation());
	return "index";
    }

    @RequestMapping(value = "/project/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String edit(ModelMap model, @PathVariable BigInteger id) {
	LOGGER.info("/project/edit/" + id + " is called");

	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "edit/project");
	model.addAttribute("content", this.contentController.getContents("project"));
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation());
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation());
	model.addAttribute("project", this.projectRepository.findOne(id));
	return "index";
    }

    @RequestMapping(value = "/project/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(ModelMap model, @PathVariable BigInteger id) {
	LOGGER.info("/project/delete/" + id + " is called");

	this.projectRepository.delete(id);
	return "redirect:/project";
    }

    @RequestMapping(value = "/project/add", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String addGet(ModelMap model) {
	LOGGER.info("/project/add/ is called GET");

	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "edit/project");
	model.addAttribute("content", this.contentController.getContents("project"));
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation());
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation());
	model.addAttribute("project", new ProjectContent());
	return "index";
    }

    @RequestMapping(value = "/project/add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String addPost(ModelMap model, @ModelAttribute("project") ProjectContent project) {
	LOGGER.info("/project/add/ is called POST");

	this.projectRepository.save(project);
	return "redirect:/project";
    }

    private Page<ProjectContent> getProjectContent(int page) {
	PageRequest request = new PageRequest(page - 1, 4, Sort.Direction.DESC, "id");
	return this.projectRepository.findAll(request);
    }
}
