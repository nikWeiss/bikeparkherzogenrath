package com.weiss.forum.filehandler;

import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Niklas
 */
public interface FileHandler {

    public List<String> listFolders();

    public List<String> listFilesOfFolder(String folder);
    
    public InputStream getImage(String path);
    
    public InputStream getLargeImage(String path);

}
