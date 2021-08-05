package com.SpringSecurity.normalthings.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class ModelStudent{
	private String name;
	private String adress;
	private String phone;

	@Id
	private String username;
	private String password;
	
	
	
}
