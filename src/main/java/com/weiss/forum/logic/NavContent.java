package com.weiss.forum.logic;

/**
 *
 * @author Niklas
 */
public class NavContent {

    private String link;
    private String name;
    private String authorization;

    public NavContent(String link, String name, String authorization) {
	this.link = link;
	this.name = name;
	this.authorization = authorization;
    }

    public String getLink() {
	return this.link;
    }

    public String getName() {
	return this.name;
    }

    public String getAuthorization() {
	return authorization;
    }

    public void setAuthorization(String authorization) {
	this.authorization = authorization;
    }
}
