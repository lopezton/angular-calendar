package com.xpanxion.trugrade.objects.response;

public class ValidationErrorResponse extends ErrorResponse {
	
	public ValidationErrorResponse() {
		this.errorType = "validation";
	}
}
