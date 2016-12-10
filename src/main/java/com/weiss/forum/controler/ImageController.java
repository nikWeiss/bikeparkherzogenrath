package com.weiss.forum.controler;

import com.weiss.forum.filehandler.DropboxFileHandler;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@RequestParam String image) throws IOException {
	DropboxFileHandler dropboxFileHandler = new DropboxFileHandler();
	InputStream in = dropboxFileHandler.getImage(image);
	return IOUtils.toByteArray(in);
    }

    @ResponseBody
    @RequestMapping(value = "/image/large", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] imageLarge(@RequestParam String image) throws IOException {
	DropboxFileHandler dropboxFileHandler = new DropboxFileHandler();
	InputStream in = dropboxFileHandler.getLargeImage(image);
	return IOUtils.toByteArray(in);
    }
}
