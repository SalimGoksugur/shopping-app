package com.patika.shoppingapp.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentDto {
	
	@NotBlank(message = "Comment can not be null!")
	@Size(max = 500, message = "Comment length can not be more than 500")
	private String content;
	
}
