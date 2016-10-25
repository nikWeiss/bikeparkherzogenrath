package com.weiss.forum.logic;

/**
 *
 * @author Niklas
 */
public class NavContent {

    private String link;
    private String name;
    
    public NavContent(String link, String name){
	this.link = link;
	this.name = name;
    }

    public String getLink() {
	return this.link;
    }
    
    public String getName(){
	return this.name;
    }
}
