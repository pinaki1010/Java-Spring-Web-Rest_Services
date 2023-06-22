package com.pinaki.springboot.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int countID=0;
	static {
		users.add(new User(++countID,"Pinaki",LocalDate.now().minusYears(25)));
		users.add(new User(++countID,"Sattwiki",LocalDate.now().minusYears(30)));
		users.add(new User(++countID,"Priya",LocalDate.now().minusYears(35)));	
		
	}
	
	public List<User> findAll(){
		
		return users;
	}
	
	public User findoneById(int id) {
		
		
 
		Predicate<? super User> predicate=user-> user.getId().equals(id);
		
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public void createUser(User user) {
		user.setId(++countID);
		
		users.add(user);
		
	}

	public void deleteById(int id) {
		

		Predicate<? super User> predicate=user-> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
