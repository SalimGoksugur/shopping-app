package com.patika.shoppingapp.controllers;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patika.shoppingapp.dtos.CreateCommentDto;
import com.patika.shoppingapp.services.CommentService;

@RestController
@RequestMapping("/api/v1/comments")

public class CommentController {
	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		
		this.commentService = commentService;
	}
	
	@GetMapping
	public ResponseEntity getAll() {
		
		return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity getById (@PathVariable Long id) {
		
		return new ResponseEntity<> (commentService.getById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/byProductId/{productId}")
	
	public ResponseEntity getByProductId(@PathVariable Long productId) {
		
		return new ResponseEntity<>(commentService.getByProductId(productId), HttpStatus.OK);
	}
	
	@GetMapping(path = "/byProductIdAndDates/{productId}")
	public ResponseEntity getByProductIdAndDates(@PathVariable Long productId,
												 @RequestParam(value = "firstCommentDate") @DateTimeFormat(pattern="yyyy-MM-dd")Date firstCommentDate,
												 @RequestParam(value = "lastCommentDate")  @DateTimeFormat(pattern="yyyy-MM-dd") Date lastCommentDate) {
		
		return new ResponseEntity<>(commentService.getByProductIdAndDates(productId, firstCommentDate, lastCommentDate), HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/byUserId/{userId}")
	public ResponseEntity getByUserId(@PathVariable Long userId) {
		
		return new ResponseEntity<>(commentService.getByUserId(userId), HttpStatus.OK);
	}
	
	@GetMapping(path = "/byUserIdAndDates/{userId}")
	public ResponseEntity getByUserIdAndDates(@PathVariable Long userId,
											  @RequestParam(value = "firstCommentDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date firstCommentDate,
											  @RequestParam(value = "lastCommentDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date lastCommentDate) {
		
		return new ResponseEntity<>(commentService.getByUserIdAndDates(userId, firstCommentDate, lastCommentDate), HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/{userId}/{productId}")
	public ResponseEntity create(@RequestBody CreateCommentDto commentDto, 
								 @PathVariable Long userId,
								 @PathVariable Long productId) {
		
		return new ResponseEntity<>(commentService.create(userId, productId, commentDto), HttpStatus.CREATED);
	}
	
	
}
