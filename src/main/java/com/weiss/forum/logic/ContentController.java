package com.weiss.forum.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niklas
 */
public class ContentController {

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
