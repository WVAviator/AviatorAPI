package com.wvaviator.aviatorapi.File;

public class NonexistentFileException extends Exception {
	
	private String message;
	
	public NonexistentFileException() {
		super();
	}
	
	public NonexistentFileException(String message) {
		super(message);
		this.message = message;
	}
	
	public String toString() {
		return message;
	}
	
	public String getMessage() {
		return message;
	}

}
