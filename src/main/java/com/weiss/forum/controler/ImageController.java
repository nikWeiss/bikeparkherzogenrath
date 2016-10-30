package com.weiss.forum.controler;

import com.weiss.forum.filehandler.DropboxFileHandler;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Niklas
 */
@Controller
public class ImageController {

    @ResponseBody
    @RequestMapping(value = "/photo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] testphoto(@RequestParam String image) throws IOException {
//	InputStream in = new BufferedInputStream(new FileInputStream(new File(image)));
	DropboxFileHandler dropboxFileHandler = new DropboxFileHandler();
	InputStream in = dropboxFileHandler.getImage("/test.jpeg");
	return IOUtils.toByteArray(in);
    }
}
