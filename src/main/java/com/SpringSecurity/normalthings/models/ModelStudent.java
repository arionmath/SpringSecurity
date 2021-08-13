package com.SpringSecurity.normalthings.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

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
	@NotBlank
	private String name;
	private String adress;
	private String phone;

	@Id
	@NotBlank(message = "\n===== USERNAME null===== \n")
	private String username;
	@NotBlank(message = "\n===== password null===== \n")
	@Length(min = 3,message = "\n----password weak----\n")
	private String password;
	
	
	
}
