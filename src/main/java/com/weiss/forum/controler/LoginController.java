package com.weiss.forum.controler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niklas
 */
@Controller
public class LoginController extends MyController {

    @RequestMapping("/login")
    public String login(ModelMap model) {
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "login");
	this.contentController.setNavigation(model);

	return "index";
    }

    @RequestMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    public String logout(ModelMap model, HttpServletRequest request) throws ServletException {
	request.logout();

	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "index");
	this.contentController.setNavigation(model);

	return "index";
    }
}
