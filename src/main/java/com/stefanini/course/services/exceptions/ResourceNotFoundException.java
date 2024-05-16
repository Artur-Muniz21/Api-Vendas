package com.stefanini.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) { // id do obj que eu tentei encontrar
		super("Resource not found. Id" + id);
	}
}
