package com.SpringSecurity.normalthings.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.normalthings.models.ModelStudent;
import com.SpringSecurity.normalthings.repositorie.RepositorieStudent;

//Simple controller needs one view but RestController not.
@RestController

public class ControllerStudent {
	@Autowired
	RepositorieStudent RS;
	
	@GetMapping(path = "/")
	public List<ModelStudent> findAll(){
		return RS.findAll();
	}
	
	@GetMapping(path = "/one")
	public ModelStudent findByName() {
		return RS.getById(null);
	}
	
	
	@GetMapping(path = "/user")
	@PreAuthorize("hasRole('USER')")
	public String messageForUser() {
		return "essa é a mensagem para o usuario user";
	}
	
	@PostMapping(path = "/user/{msg}")
	@PreAuthorize("hasRole('USER')")
	public String postMessageForUser(@PathVariable String msg) {
		return "essa é a mensagem do user "+msg;
	}
	
	@GetMapping("/info")
	public String userDetails(@AuthenticationPrincipal UserDetails u) {
		System.out.println("metodo userdetails"+u);
		return "Seu user é " + u.toString();
	}
	
	@PostMapping("/")
	public ResponseEntity<ModelStudent> createStudent(@Valid @RequestBody ModelStudent user) {
		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		user.setPassword(pe.encode(user.getPassword()));
		
		RS.save(user);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
