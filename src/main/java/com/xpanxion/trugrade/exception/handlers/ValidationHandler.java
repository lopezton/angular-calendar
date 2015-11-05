package com.xpanxion.trugrade.exception.handlers;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xpanxion.trugrade.objects.response.ValidationErrorResponse;

@ControllerAdvice
public class ValidationHandler {

	@ResponseBody
	@ExceptionHandler
	public ValidationErrorResponse handleValidationException(MethodArgumentNotValidException e) {
		final ValidationErrorResponse response = new ValidationErrorResponse();
		for (ObjectError error : e.getBindingResult().getAllErrors()) {
			for (Object arg : error.getArguments()) {
				final DefaultMessageSourceResolvable msg = (DefaultMessageSourceResolvable) arg;
				response.getErrorMessages().add("'" + msg.getDefaultMessage() + "' " + error.getDefaultMessage());
			}
		}
		return response;
	}
}
