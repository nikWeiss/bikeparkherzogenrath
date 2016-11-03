package com.weiss.forum.controler;

import com.weiss.forum.db.repository.ProjectRepository;
import com.weiss.forum.logic.ContentController;
import com.weiss.forum.logic.ProjectContent;
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
    private ProjectRepository projectRepo;

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
	this.projectRepo.deleteAll();
	
	ProjectContent content = new ProjectContent();
	content.setBody("Test Body");
	content.setFooter("Test Footer");
	content.setImage("Test Image");
	this.projectRepo.save(content);
	ProjectContent content2 = new ProjectContent();
	content2.setBody("Test Body");
	content2.setFooter("Test Footer");
	content2.setImage("Test Image");
	this.projectRepo.save(content2);
	
	for(ProjectContent single: this.projectRepo.findAll()){
	    System.out.println(single);
	}
	
	return "test/jsp-spring-boot";
    }
}
