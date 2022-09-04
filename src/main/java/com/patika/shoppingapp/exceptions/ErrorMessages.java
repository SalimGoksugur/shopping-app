package com.patika.shoppingapp.exceptions;

public enum ErrorMessages {

	 ITEM_NOT_FOUND("Item not found!");
	
	private String message;

	ErrorMessages(String message) {
		this.message = message;
		}
	
	public String getMessage() {
        return message;
    }

    public String toString() {
        return message;
    }
}
