package com.pinaki.springboot.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		new User(1,"Pinaki",LocalDate.now().minusYears(25));
		new User(1,"Pinaki",LocalDate.now().minusYears(25));
		
		
	}

}
