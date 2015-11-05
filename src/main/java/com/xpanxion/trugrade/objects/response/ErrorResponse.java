package com.xpanxion.trugrade.objects.response;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse extends GenericServerResponse {

	protected String errorType = "generic";
	protected List<String> errorMessages = new ArrayList<>();

	public ErrorResponse() {
		this.hasErrors = true;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
}
