package com.pinaki.springboot.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		
		this.messageSource=messageSource;
		
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String helloWorld(){
		return "Hello  Pinaki";
	}
	//Returning Bean to Method
	@RequestMapping(method=RequestMethod.GET,path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello Pinaki");
	}
	//Calling through Path Variable
	@RequestMapping(method=RequestMethod.GET,path="/hello-world-path/variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello %s",name));
	}
	//Internatiolization
	
	@RequestMapping(method=RequestMethod.GET,path="/hello-world-inter")
	public String helloWorldInter(){
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morining.messages", null,"Default Message",locale);
		
	}
	

}
