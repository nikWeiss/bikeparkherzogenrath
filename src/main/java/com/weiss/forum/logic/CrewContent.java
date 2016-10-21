package com.weiss.forum.logic;

/**
 *
 * @author Niklas
 */
public class CrewContent implements Content {

    @Override
    public String getHeader() {
	return "TEST HEADER";
    }

    @Override
    public String getBody() {
	return "Dies ist ein Test für die Contents der Seite. Bitte beachten Sie diese Teststrings nicht. Hier könnte ihre Testnachricht stehen";
    }

    @Override
    public String getFooter() {
	return "TEST FOOTER";
    }

    @Override
    public String getImage() {
	return "C:\\Users\\Niklas\\Desktop\\WhatsApp Image 2016-08-19 at 14.21.55.jpeg";
    }

}
