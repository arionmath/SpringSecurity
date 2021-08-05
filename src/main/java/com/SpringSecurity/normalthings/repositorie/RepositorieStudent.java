package com.SpringSecurity.normalthings.repositorie;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.SpringSecurity.normalthings.models.ModelStudent;
@Repository
public class RepositorieStudent {
	
	public ModelStudent findByName(){
		System.out.println("\n===findnamen===\n");
		return new ModelStudent("Jose Alves Cabral", "findById", "8888888");
	}
	
	public List<ModelStudent> findAll(){
		return Arrays.asList(new ModelStudent("Jose Alves", "findAll", "8888888"),
				new ModelStudent("Amanda Joana", "findAll", "8888888"),
				new ModelStudent("mateus goncalves", "findAll", "8888888"),
				new ModelStudent("Bob Marley", "findAll", "8888888"));
	}

}
