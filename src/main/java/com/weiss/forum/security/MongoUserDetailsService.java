package com.weiss.forum.security;

import com.weiss.forum.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Niklas
 */
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	MyUser user = this.userRepository.findByUsername(username);
	if (user != null) {
	    return user.getSpringUser();
	}
	throw new UsernameNotFoundException("Username " + username + " not found.");
    }

}
