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
	ret.add(new NavContent("/", "Bikepark Herzogenrath"));
	ret.add(new NavContent("project", "Projekt"));
	ret.add(new NavContent("dates", "Termine"));
	ret.add(new NavContent("crew", "Team"));
	return ret;
    }

    public List<NavContent> getRightNaviation(String language) {
	List<NavContent> ret = new ArrayList<>();
	ret.add(new NavContent("login", "Anmelden"));
	ret.add(new NavContent("register", "Registrierung"));
	return ret;
    }

    public List<NavContent> getAdminLeftNavigation(String language) {
	List<NavContent> ret = new ArrayList<>();
	ret.add(new NavContent("/admin", "Bikepark Herzogenrath"));
	ret.add(new NavContent("/admin/project", "Projekt"));
	ret.add(new NavContent("/admin/dates", "Termine"));
	ret.add(new NavContent("/admin/crew", "Team"));
	return ret;
    }

    public List<NavContent> getAdminRightNaviation(String language) {
	List<NavContent> ret = new ArrayList<>();
	ret.add(new NavContent("login", "Anmelden"));
	ret.add(new NavContent("register", "Registrierung"));
	return ret;
    }

    public List<Content> getContents(String module) {
	List<Content> ret = new ArrayList<>();
	if (module.equals("crew")) {
	    ret.addAll(this.crewRepository.findAll());
	    for (int i = 0; i < 10; i++) {
//		Content crewContent = new CrewContent();
//		ret.add(crewContent);
	    }
	} else if (module.equals("project")) {
	    ret.addAll(this.projectRepository.findAll());
	    for (int i = 0; i < 10; i++) {
//		Content crewContent = new ProjectContent();
//		ret.add(crewContent);
	    }
	}
	return ret;
    }
}
