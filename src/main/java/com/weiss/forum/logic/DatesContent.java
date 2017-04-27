package com.weiss.forum.logic;

import java.util.Date;

/**
 *
 * @author Niklas
 */
public class DatesContent extends Content {

    private Date date;

    private String art;

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public String getArt() {
	return art;
    }

    public void setArt(String art) {
	this.art = art;
    }

}
