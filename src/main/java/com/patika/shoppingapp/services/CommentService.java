package com.patika.shoppingapp.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.patika.shoppingapp.dtos.CommentDto;
import com.patika.shoppingapp.dtos.CreateCommentDto;
import com.patika.shoppingapp.response.RestResponse;

@Service
public interface CommentService {
	
	RestResponse<List<CommentDto>> getAll();
	
	RestResponse<CommentDto> create(Long userId, Long ProductId, CreateCommentDto createCommentDto);
	
	RestResponse<List<CommentDto>> getByProductId(Long productId);
	
	RestResponse<List<CommentDto>> getByProductIdAndDates(Long productId, Date firstCommentDate, Date lastCommentDate);
	
	RestResponse<List<CommentDto>> getByUserId(Long userId);
	
	RestResponse<List<CommentDto>> getByUserIdAndDates(Long userId, Date firstCommentDate, Date lastCommentDate);

	RestResponse<CommentDto> getById(Long id);
	
	RestResponse<Void> delete (Long id);
	

}
