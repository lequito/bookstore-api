package com.alexbookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErros extends StandardError {

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationErros() {
		super();
	}

	public ValidationErros(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}

	public List<FieldMessage> getErros() {
		return errors;
	}

	public void addErrors(String fildName, String message) {
		this.errors.add(new FieldMessage(fildName, message));
	}

	
	
}
