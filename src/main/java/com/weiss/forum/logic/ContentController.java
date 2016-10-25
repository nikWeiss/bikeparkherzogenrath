package com.weiss.forum.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niklas
 */
public class ContentController {
    
    public List<NavContent> getLeftNavigation(String language) {
	List<NavContent> ret = new ArrayList<>();
	ret.add(new NavContent("/", "Bikepark Herzogenrath"));
	ret.add(new NavContent("project", "Projekt"));
	ret.add(new NavContent("dates", "Termine"));
	ret.add(new NavContent("crew", "Team"));
//	ret.add(new NavContent("forum", "Forum"));
	return ret;
    }
    
    public List<NavContent> getRightNaviation(String language) {
	List<NavContent> ret = new ArrayList<>();
	ret.add(new NavContent("login", "Anmelden"));
	ret.add(new NavContent("register", "Registrierung"));
	return ret;
    }

    public List<Content> getContents(String module) {
	List<Content> ret = new ArrayList<>();
	if (module.equals("crew")) {
	    for (int i = 0; i < 10; i++) {
		Content crewContent = new CrewContent();
		ret.add(crewContent);
	    }
	} else if (module.equals("project")) {
	    for (int i = 0; i < 10; i++) {
		Content crewContent = new ProjectContent();
		ret.add(crewContent);
	    }
	}
	return ret;
    }
}
