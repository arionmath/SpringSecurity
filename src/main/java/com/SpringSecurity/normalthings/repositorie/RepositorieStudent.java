package com.SpringSecurity.normalthings.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.normalthings.models.ModelStudent;

public interface RepositorieStudent extends JpaRepository<ModelStudent, String>  {
	
	

}
