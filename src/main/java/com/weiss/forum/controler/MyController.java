package com.weiss.forum.controler;

import com.weiss.forum.logic.ContentController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Niklas
 */
public class MyController {

    @Autowired
    protected ContentController contentController;
}
