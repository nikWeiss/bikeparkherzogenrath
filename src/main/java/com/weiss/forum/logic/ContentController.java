package com.weiss.forum.logic;

import com.weiss.forum.db.repository.CrewRepository;
import com.weiss.forum.db.repository.DatesRepository;
import com.weiss.forum.db.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

/**
 *
 * @author Niklas
 */
public class ContentController {

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private DatesRepository datesRepository;

    @Autowired
    private ProjectRepository projectRepository;
    
    public NavContent getBrand() {
	return new NavContent("/", "Bikepark Herzogenrath", "permitAll()");
    }

    public List<NavContent> getLeftNavigation() {
	List<NavContent> ret = new ArrayList<>();
	ret.add(new NavContent("/project", "Projekt", "permitAll()"));
	ret.add(new NavContent("/crew", "Team", "permitAll()"));
	return ret;
    }

    public List<NavContent> getRightNaviation() {
	List<NavContent> ret = new ArrayList<>();
	ret.add(new NavContent("/login", "Anmelden", "!isAuthenticated()"));
	ret.add(new NavContent("/register", "Registrierung", "!isAuthenticated()"));
	ret.add(new NavContent("/logout", "Abmelden", "isAuthenticated()"));
	return ret;
    }

    public List<Content> getContents(String module) {
	List<Content> ret = new ArrayList<>();
	switch (module) {
	    case "crew":
		ret.addAll(this.crewRepository.findAll());
		break;
	    case "project":
		ret.addAll(this.projectRepository.findAllByOrderByIdDesc());
		break;
	    case "index":
		ret.add(this.projectRepository.findFirstByOrderByIdDesc());
		break;
	    case "dates":
		ret.addAll(this.datesRepository.findAllByOrderByIdDesc());
		break;
	    default:
		break;
	}
	return ret;
    }

    public void setNavigation(ModelMap model) {
	model.addAttribute("brand", this.getBrand());
	model.addAttribute("leftNavigation", this.getLeftNavigation());
	model.addAttribute("rightNavigation", this.getRightNaviation());
    }

    public void setHeaders(ModelMap model, String title, String site) {
	model.addAttribute("title", title);
	model.addAttribute("site", site);
    }
}
