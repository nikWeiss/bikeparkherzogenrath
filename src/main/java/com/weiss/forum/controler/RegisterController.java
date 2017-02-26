package com.weiss.forum.controler;

import com.weiss.forum.db.repository.UserRepository;
import com.weiss.forum.logic.ContentController;
import com.weiss.forum.security.MyUser;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Niklas
 */
@Controller
public class RegisterController {

    @Autowired
    private ContentController contentController;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
	model.addAttribute("user", new MyUser());
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "register");
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation("ger"));

	return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(ModelMap model, @ModelAttribute("user") MyUser user) {
	
	MyUser findByUsername = this.userRepository.findByUsername(user.getUsername());
	if(findByUsername == null)
	{
	    user.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
	    this.userRepository.insert(user);
	    model.addAttribute("message", "Registrierung ist erfolgreich.");
	}
	else
	{
	    model.addAttribute("message", "Der Nutzername ist schon vergeben.");
	}
	
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "register");
	model.addAttribute("leftNavigation", this.contentController.getLeftNavigation("ger"));
	model.addAttribute("rightNavigation", this.contentController.getRightNaviation("ger"));

	return "index";
    }
}
