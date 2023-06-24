package com.pinaki.springboot.restfulwebservices.User;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	
	private UserDaoService userDaoService;
	
	public UserResource(UserDaoService userDaoService) {
		this.userDaoService=userDaoService;
	}
	
	//Get/user
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return userDaoService.findAll();
		
	}
	
	//Get/user/id
	
		@GetMapping("/users/{id}")
		public User getUserById(@PathVariable int id){
			
			User user = userDaoService.findoneById(id);
			
			if(user==null) {
				throw new UserNotFoundException("id:"+id);
			}
			
			return userDaoService.findoneById(id);
			
		}
		
	//save/user
   //Using of Response entity to send proper response
	@PostMapping("/save/user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		userDaoService.createUser(user);
		
		//return ResponseEntity.created(null).build();
		
		//for specific uri sent we can add uri like user/{id}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
				return ResponseEntity.created(location).build();		
		
	}
	
	
	//delete/user/id
	
			@DeleteMapping("/users/{id}")
			public void deleteUserById(@PathVariable int id){
				
				userDaoService.deleteById(id);
				
					
				
			}
			
			//Get/user/id
			
//			@GetMapping("/users/{id}")
//			public EntityModel<User> retriveUserHeteros(@PathVariable int id){
//				
//				User user = userDaoService.findoneById(id);
//				
//				
//				//1st we have user class to EntityModel
//				
//				EntityModel<User> entityModel = EntityModel.of(user);
//				
//				//Then By webMVCLinkBuilder we have added particular method link
//				WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
//				
//				//Then we added link to key value in json named as all-users
//				
//				entityModel.add(link.withRel("all-users"));
//				
//				return entityModel;
//				
//			}
			
			
	

}
