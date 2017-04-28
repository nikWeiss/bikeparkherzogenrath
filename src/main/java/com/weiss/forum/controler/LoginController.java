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
	this.contentController.setHeaders(model, "Bikepark Herzogenrath", "login");
	this.contentController.setNavigation(model);

	return "index";
    }

    @RequestMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    public String logout(ModelMap model, HttpServletRequest request) throws ServletException {
	request.logout();

	this.contentController.setHeaders(model, "Bikepark Herzogenrath", "index");
	this.contentController.setNavigation(model);

	return "index";
    }
}
