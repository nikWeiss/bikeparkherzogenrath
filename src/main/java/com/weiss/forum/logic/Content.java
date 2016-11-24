package com.weiss.forum.logic;

import java.math.BigInteger;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Niklas
 */
public abstract class Content {

    @Id
    protected BigInteger id;
    protected String header;
    protected String body;
    protected String footer;
    protected String image;

    public BigInteger getId() {
	return id;
    }

    public void setId(BigInteger id) {
	this.id = id;
    }

    public String getHeader() {
	return header;
    }

    public void setHeader(String header) {
	this.header = header;
    }

    public String getBody() {
	return body;
    }

    public void setBody(String body) {
	this.body = body;
    }

    public String getFooter() {
	return footer;
    }

    public void setFooter(String footer) {
	this.footer = footer;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }
}
