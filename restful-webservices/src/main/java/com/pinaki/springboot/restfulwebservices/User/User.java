package com.pinaki.springboot.restfulwebservices.User;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	
	private Integer id;
	//for the API naming changes we need to provide JsonProperty 
	@Size(min=2)
	@JsonProperty("user_name")
	private String name;
	@Past
	@JsonProperty("birth_date")
	private LocalDate birthDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	public User(Integer id, String name, LocalDate birthDate) {
	
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
	
	

}
