package com.grupoestudo.normalthings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoestudo.normalthings.models.ModelStudent;
import com.grupoestudo.normalthings.repositorie.RepositorieStudent;

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

}
