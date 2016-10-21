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
	for (int i = 0; i < 10; i++) {
	    CrewContent crewContent = new CrewContent();
	    ret.add(crewContent);
	}
	return ret;
    }
}
