package com.weiss.forum.security;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.weiss.forum.db.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Niklas
 */
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private MongoClient mongoClient;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	MyUser user = this.userRepository.findFirstByUsername(username);
	User springUser = user.getSpringUser();
	return springUser;
    }

}
