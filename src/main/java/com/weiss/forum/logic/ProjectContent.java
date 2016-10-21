package com.weiss.forum.logic;

/**
 *
 * @author Niklas
 */
public class ProjectContent extends Content {

    @Override
    public String getHeader() {
	return "Content Test";
    }

    @Override
    public String getBody() {
	return "Body Test<br />Dies ist ein Test für die Contents der Seite.<br />Bitte beachten Sie diese Teststrings nicht."
		+ "<br /><br /> Hier könnte ihre Testnachricht stehen";
    }

    @Override
    public String getFooter() {
	return "Footer Test";
    }

    @Override
    public String getImage() {
	return "Not an image";
    }

}
