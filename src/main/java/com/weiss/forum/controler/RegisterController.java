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
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Niklas
 */
@Controller
public class RegisterController {

    @Autowired
    private ContentController contentController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
	model.addAttribute("user", new MyUser());
	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "register");
	this.contentController.setNavigation(model);

	return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(ModelMap model, @ModelAttribute("user") MyUser user) {
	MyUser findByUsername = this.userRepository.findByUsername(user.getUsername());

	if (user.getUsername().length() > 0 && user.getPassword().length() > 0) {
	    if (findByUsername == null) {
		user.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
		String passwordEncoded = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordEncoded);
		this.userRepository.insert(user);
		model.addAttribute("message", "Registrierung ist erfolgreich.");
	    } else {
		model.addAttribute("message", "Der Nutzername ist schon vergeben.");
	    }
	} else {
	    model.addAttribute("message", "Benutzername oder Passwort ist nicht gesetzt.");
	}

	model.addAttribute("title", "Bikepark Herzogenrath");
	model.addAttribute("site", "register");
	this.contentController.setNavigation(model);

	return "index";
    }
}
