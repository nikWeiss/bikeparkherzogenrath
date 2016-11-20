package com.weiss.forum.logic;

/**
 *
 * @author Niklas
 */
public class ProjectContent extends Content {

    public boolean isImageSet() {
	return !"".equals(this.getImage());
    }
}
