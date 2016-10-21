package com.weiss.forum.controler;

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

    @RequestMapping("/forum")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String forum(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "forum");
	return "index";
    }
}
