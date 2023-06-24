package com.pinaki.springboot.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringControllerEx {
	
	@GetMapping("/filtering")
	public SomeBean filtering() {
		return new SomeBean("Value-1","Value-2","Value-3");
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		
		SomeBean someBean = new SomeBean("Value-4","Value-5","Value-6");
		
		//creating Mapping Jackson Value
		
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		
		//Create a SimpleBeanPropertyFilter using field-1,field-2
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("fld1","fld2'");
		
		//Create Filter Provider using SomeBean and add in Bean JsonFilter
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean", filter);
		
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}

}
