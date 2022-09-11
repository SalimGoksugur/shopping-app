package com.patika.shoppingapp.exceptions;

public enum ErrorMessages {

	 ITEM_NOT_FOUND("Item not found!"),
	 USER_NOT_FOUND("User not found!"),
	 PRODUCT_NOT_FOUND("Product not found!"),
	 COMMENT_NOT_FOUND("Comment not found!");
	
	
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
