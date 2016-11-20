package com.weiss.forum.logic;

/**
 *
 * @author Niklas
 */
public class CrewContent extends Content {

    public boolean isImageSet() {
	return !"".equals(this.getImage());
    }
}
