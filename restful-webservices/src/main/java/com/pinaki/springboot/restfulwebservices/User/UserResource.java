package com.pinaki.springboot.restfulwebservices.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		userDaoService.createUser(user);
		
		//return ResponseEntity.created(null).build();
		
		//for specific uri sent we can add uri like user/{id}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
				return ResponseEntity.created(location).build();		
		
	}	
	

}
