package com.weiss.forum.filehandler;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niklas
 */
public class DropboxFileHandler implements FileHandler {

    private static final Logger LOGGER = Logger.getLogger(DropboxFileHandler.class.getName());
    private static final String ACCESS_TOKEN = "55oZM-ky6usAAAAAAAARgLzaG1hh9eBtXIB7E5awIl0wXIaJvjDtPP9Z30o3slMf";

    private DbxRequestConfig config;
    private DbxClientV2 client;

    public DropboxFileHandler() {
	this.config = new DbxRequestConfig("", "de_DE");
	this.client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    public static void main(String args[]) throws DbxException {
	DbxRequestConfig config = new DbxRequestConfig("", "de_DE");
	DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
	ListFolderResult result = client.files().listFolder("");

	while (true) {
	    for (Metadata metadata : result.getEntries()) {
		System.out.println(metadata.getClass());
		System.out.println(metadata.getPathLower());
	    }

	    if (!result.getHasMore()) {
		break;
	    }

	    result = client.files().listFolderContinue(result.getCursor());
	}
    }

    @Override
    public List<String> listFolders() {
	List<String> folders = new ArrayList<>();
	try {
	    ListFolderResult listFolder = this.client.files().listFolder("");
	    while (true) {
		for (Metadata metadata : listFolder.getEntries()) {
		    if (metadata.getClass() == FolderMetadata.class) {
			folders.add(metadata.getPathLower());
		    }
		}
		if (!listFolder.getHasMore()) {
		    break;
		}
		listFolder = this.client.files().listFolderContinue(listFolder.getCursor());
	    }
	} catch (DbxException ex) {
	    LOGGER.log(Level.WARNING, "The dropboxconnection is not working right for listFolders");
	}
	return folders;
    }

    @Override
    public List<String> listFilesOfFolder(String folder) {
	List<String> files = new ArrayList<>();
	try {
	    ListFolderResult listFolder = this.client.files().listFolder(folder);
	    for (Metadata metadata : listFolder.getEntries()) {
		if (metadata.getClass() == FileMetadata.class) {
		    files.add(metadata.getPathLower());
		}
	    }
	    return files;
	} catch (DbxException ex) {
	    LOGGER.log(Level.WARNING, "The dropboxconnection is not working right for listFolder: " + folder);
	}
	return files;
    }

    @Override
    public InputStream getImage(String path) {
	try {
	    DbxDownloader<FileMetadata> thumbnail = this.client.files().download(path);
//	    DbxDownloader<FileMetadata> thumbnail = this.client.files().getThumbnail(path);
	    return thumbnail.getInputStream();
	} catch (DbxException ex) {
	    LOGGER.log(Level.WARNING, "The dropboxconnection is not working right for image: " + path);
	    return null;
	}
    }
}
