package com.pinaki.springboot.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	//URI Versioning
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionPerson() {
		
		return new PersonV1("Pinaki-V1");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionPerson() {
		
		return new PersonV2(new Name("Pinaki", "V2"));
	}
	
	//Param Version
	

	@GetMapping(path = "/person",params="version=1")
	public PersonV1 getFirstVersionPersonRequestParam() {
		
		return new PersonV1("Pinaki-V1");
	}
	
	@GetMapping(path = "/person",params="version=2")
	public PersonV2 getSecondVersionPersonRequestParam() {
		
		return new PersonV2(new Name("Pinaki", "V2"));
	}
	
	//Header Version
	
	@GetMapping(path = "/person/header",headers ="x-api-version=1")
	public PersonV1 getFirstVersionPersonRequestHeader() {
		
		return new PersonV1("Pinaki-V1");
	}
	
	@GetMapping(path = "/person/header",headers ="x-api-version=2")
	public PersonV2 getSecondVersionPersonRequestHeader() {
		
		return new PersonV2(new Name("Pinaki", "V2"));
	}
	
	//Media Content
	

	@GetMapping(path = "/person/accept",produces  ="application/pinaki.app.v1+json")
	public PersonV1 getFirstVersionPersonRequestAccept() {
		
		return new PersonV1("Pinaki-V1");
	}
	
	@GetMapping(path = "/person/accept",produces ="application/pinaki.app.v2+json")
	public PersonV2 getSecondVersionPersonRequestAccept() {
		
		return new PersonV2(new Name("Pinaki", "V2"));
	}
	
	
	
}
