package com.SpringSecurity.SecurityThings.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.SpringSecurity.normalthings.models.ModelStudent;
import com.SpringSecurity.normalthings.repositorie.RepositorieStudent;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	RepositorieStudent REPO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ModelStudent u = Optional.ofNullable(REPO.findById(username)).
		orElseThrow(() -> new UsernameNotFoundException("===User not found===")).get();
		
		@SuppressWarnings("unused")
		List< GrantedAuthority > listAuthority1 = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		List< GrantedAuthority > listAuthority2 = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		User springUserDetails = new User(u.getUsername(), u.getPassword(), listAuthority2);
		return springUserDetails;
	}

}
