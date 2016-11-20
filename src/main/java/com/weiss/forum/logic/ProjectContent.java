package com.weiss.forum.logic;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 *
 * @author Niklas
 */
public class ProjectContent extends Content {

    Logger LOGGER = Logger.getLogger(ProjectContent.class);

    protected String imageList;

    public boolean isImageSet() {
	return !"".equals(this.getImage());
    }

    public boolean isImageListSet() {
	return (!"".equals(this.getImageList())) && null != this.getImageList();
    }

    public void setImageList(String imageList) {
	this.imageList = this.imageList;
    }

    public String getImageList() {
	return this.imageList;
    }

    public String[] getImageListArray() {
	LOGGER.info(Arrays.toString(this.imageList.split(";")));
	return this.imageList.split(";");
    }
}
