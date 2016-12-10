package com.weiss.forum.filehandler;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DownloadBuilder;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.GetMetadataBuilder;
import com.dropbox.core.v2.files.GetThumbnailBuilder;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.ThumbnailSize;
import java.io.FileInputStream;
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

    @Override
    public List<String> listFolders() {
	List<String> folders = new ArrayList<>();
	folders.addAll(this.listFolders(""));
	return folders;
    }

    private List<String> listFolders(String folder) {
	List<String> folders = new ArrayList<>();
	try {
	    ListFolderResult listFolder = this.client.files().listFolder(folder);
	    while (true) {
		for (Metadata metadata : listFolder.getEntries()) {
		    if (metadata.getClass() == FolderMetadata.class) {
			folders.add(metadata.getPathLower());
			folders.addAll(this.listFolders(metadata.getPathLower()));
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
	String pathPrefix = "/Bikepark";
	String longpath = pathPrefix + path;
	longpath = longpath.replace("//", "/");
	
	try {
	    GetThumbnailBuilder thumbnailBuilder = this.client.files().getThumbnailBuilder(longpath);
	    thumbnailBuilder.withSize(ThumbnailSize.W640H480);
	    DbxDownloader<FileMetadata> thumbnail = thumbnailBuilder.start();
	    return thumbnail.getInputStream();
	} catch (DbxException ex) {
	    LOGGER.log(Level.WARNING, "The dropboxconnection is not working right for image: " + longpath);
	    return null;
	}
    }

    @Override
    public InputStream getLargeImage(String path) {
	String pathPrefix = "/Bikepark";
	String longpath = pathPrefix + path;
	longpath = longpath.replace("//", "/");
	
	try {
	    DbxDownloader<FileMetadata> download = this.client.files().download(longpath);
	    return download.getInputStream();
	} catch (DbxException ex) {
	    LOGGER.log(Level.WARNING, "The dropboxconnection is not working right for image: " + longpath);
	    return null;
	}
    }
}
