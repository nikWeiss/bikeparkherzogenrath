package com.weiss.forum.logic;

/**
 *
 * @author Niklas
 */
public class ProjectContent extends Content {

    private Integer position;

    public Integer getPosition() {
	return position;
    }

    public void setPosition(Integer position) {
	this.position = position;
    }

    public boolean isImageSet() {
	return (!"".equals(this.getImage())) && null != this.getImage() && !this.getImage().contains(";");
    }

    public boolean isImageListSet() {
	return (!"".equals(this.getImage())) && null != this.getImage() && this.getImage().contains(";");
    }

    public String[] getImageListArray() {
	return this.getImage().split(";");
    }

    public void setImageListArray(String[] imagelist) {
	String join = String.join(";", imagelist);
	this.setImage(join);
    }
}
