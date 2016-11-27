package com.weiss.forum.logic;

import com.weiss.forum.db.repository.CrewRepository;
import com.weiss.forum.db.repository.DatesRepository;
import com.weiss.forum.db.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

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

    public List<NavContent> getLeftNavigation(String language) {
	List<NavContent> ret = new ArrayList<>();
	ret.add(new NavContent("/", "Bikepark Herzogenrath", "permitAll()"));
	ret.add(new NavContent("/project", "Projekt", "permitAll()"));
	ret.add(new NavContent("/dates", "Termine", "permitAll()"));
	ret.add(new NavContent("/crew", "Team", "permitAll()"));
//	ret.add(new NavContent("/forum", "Forum", "isAuthenticated()"));
	return ret;
    }

    public List<NavContent> getRightNaviation(String language) {
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
	    default:
		break;
	}
	return ret;
    }
}
