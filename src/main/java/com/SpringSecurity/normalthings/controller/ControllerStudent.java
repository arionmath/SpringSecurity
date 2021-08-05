package com.SpringSecurity.normalthings.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.normalthings.models.ModelStudent;
import com.SpringSecurity.normalthings.repositorie.RepositorieStudent;

import ch.qos.logback.core.net.SyslogOutputStream;

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
		return RS.findByName();
	}
	
	
	@GetMapping(path = "/user")
	@PreAuthorize("hasRole('user')")
	public String messageForUser() {
		return "essa é a mensagem para o usuario user";
	}
	
	@PostMapping(path = "/user/{msg}")
	@PreAuthorize("hasRole('user')")
	public String postMessageForUser(@PathVariable String msg) {
		return "essa é a mensagem do user "+msg;
	}
	
	@GetMapping("/info")
	public String userDetails(@AuthenticationPrincipal UserDetails u) {
		System.out.println("metodo userdetails"+u);
		return "Seu user é " + u.toString();
	}

}
