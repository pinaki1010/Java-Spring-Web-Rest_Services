package com.pinaki.springboot.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Static Filtering @JsonIgnoreProperties ,@JsonIgnore
//@JsonIgnoreProperties({"fld2","fld3"})

@JsonFilter("SomeBean")
public class SomeBean {
	
	private String fld1;
	//@JsonIgnore
	private String fld2;
	private String fld3;
	
	public SomeBean(String fld1, String fld2, String fld3) {
		super();
		this.fld1 = fld1;
		this.fld2 = fld2;
		this.fld3 = fld3;
	}

	public String getFld1() {
		return fld1;
	}

	public String getFld2() {
		return fld2;
	}

	public String getFld3() {
		return fld3;
	}

	@Override
	public String toString() {
		return "SomeBean [fld1=" + fld1 + ", fld2=" + fld2 + ", fld3=" + fld3 + "]";
	}
	
	

}
