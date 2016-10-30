package com.weiss.forum.logic;

/**
 *
 * @author Niklas
 */
public class CrewContent extends Content {

    public String getHeader() {
	return "TEST HEADER";
    }

    public String getBody() {
	return "Dies ist ein Test für die Contents der Seite. Bitte beachten Sie diese Teststrings nicht. Hier könnte ihre Testnachricht stehen";
    }

    public String getFooter() {
	return "TEST FOOTER";
    }

    public String getImage() {
	return "test.jpeg";
    }

}
