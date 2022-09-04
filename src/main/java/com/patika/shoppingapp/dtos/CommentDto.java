package com.patika.shoppingapp.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

	private Long id;
	
	private String content;
	
	private Date commentDate;
}
