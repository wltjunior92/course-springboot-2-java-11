package br.com.walterjunior.course.services.exceptions;

public class ResourceNotFoundEsception extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public  ResourceNotFoundEsception(Object id) {
		super("Resource not found. Id " + id);
	}
}
