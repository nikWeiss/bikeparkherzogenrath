package com.weiss.forum.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Niklas
 */
public class MyUser implements UserDetails, CredentialsContainer {

    private String password;
    private String username;
    private Set<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public MyUser() {
	this.accountNonExpired = true;
	this.accountNonLocked = true;
	this.credentialsNonExpired = true;
	this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return this.authorities;
    }

    @Override
    public String getPassword() {
	return this.password;
    }

    @Override
    public String getUsername() {
	return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
	return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
	return this.enabled;
    }

    @Override
    public void eraseCredentials() {
	this.authorities.clear();
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
	this.authorities = new HashSet<GrantedAuthority>(authorities);
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
	this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
	this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
	this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public User getSpringUser() {
	return new User(this.username, this.password, this.enabled, this.accountNonExpired, this.credentialsNonExpired, this.accountNonLocked, this.authorities);
    }
}
