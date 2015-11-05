package com.xpanxion.trugrade.exception.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericErrorHandler {

	public static final String GENERIC_ERROR_VIEW = "error/generic";
	
	//@ExceptionHandler
	public String handleValidationException(Exception e) {
		return GENERIC_ERROR_VIEW;
	}
}
