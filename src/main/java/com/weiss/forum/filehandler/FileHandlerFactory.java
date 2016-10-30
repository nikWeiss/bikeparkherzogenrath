package com.weiss.forum.filehandler;

/**
 *
 * @author Niklas
 */
public class FileHandlerFactory {

    public static FileHandler getInstance(String name) {
	switch (name) {
	    case "dropbox":
		return new DropboxFileHandler();
	    default:
		return null;
	}
    }
}
