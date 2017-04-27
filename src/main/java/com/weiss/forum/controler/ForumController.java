package com.weiss.forum.controler;

import com.weiss.forum.logic.ContentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niklas
 */
@Controller
public class ForumController {

    @Autowired
    private ContentController contentController;

    @RequestMapping("/forum")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String forum(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "forum");
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation());
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation());
	return "index";
    }
}
