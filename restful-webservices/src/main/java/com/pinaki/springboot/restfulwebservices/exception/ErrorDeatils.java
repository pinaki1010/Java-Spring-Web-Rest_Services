package com.pinaki.springboot.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDeatils {

	private LocalDateTime timeStamp;
	private String message;
	private String details;
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	@Override
	public String toString() {
		return "ErrorDeatils [timeStamp=" + timeStamp + ", message=" + message + ", details=" + details + "]";
	}
	public ErrorDeatils(LocalDateTime localDateTime, String message, String details) {
		super();
		this.timeStamp = localDateTime;
		this.message = message;
		this.details = details;
	}
	
	
	
}
