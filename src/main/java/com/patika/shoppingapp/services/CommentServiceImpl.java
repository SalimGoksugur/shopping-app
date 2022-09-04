package com.patika.shoppingapp.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.patika.shoppingapp.dtos.CommentDto;
import com.patika.shoppingapp.dtos.CreateCommentDto;
import com.patika.shoppingapp.entities.Comment;
import com.patika.shoppingapp.entities.Product;
import com.patika.shoppingapp.entities.User;
import com.patika.shoppingapp.exceptions.ErrorMessages;
import com.patika.shoppingapp.exceptions.ItemNotFoundException;
import com.patika.shoppingapp.mapper.CommentMapper;
import com.patika.shoppingapp.repositories.CommentRepository;
import com.patika.shoppingapp.response.RestResponse;

@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentRepository commentRepository;
	private UserService userService;
	private ProductService productService;

	public CommentServiceImpl(CommentRepository commentRepository, UserService userService, ProductService productService) {
		
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.productService = productService;
	}

	@Override
	public RestResponse<CommentDto> create(Long userId, Long productId,CreateCommentDto createCommentDto) {
		
		User user = userService.getUserEntityById(userId);
		Product product = productService.getProductEntityById(productId);	
		Comment comment = CommentMapper.INSTANCE.convertToComment(createCommentDto);
		comment.setUser(user);
		comment.setProduct(product);
		Comment createdComment = commentRepository.save(comment);
		CommentDto commentDto = CommentMapper.INSTANCE.convertToCommentDto(createdComment);
		return RestResponse.success(commentDto);		
	}
	
	@Override
	public RestResponse<List<CommentDto>> getAll() {
		
		List<Comment> comments = commentRepository.findAll();
		List<CommentDto> commentDtos = CommentMapper.INSTANCE.converToCommentDtos(comments);
		return RestResponse.success(commentDtos);
	}

	@Override
	public RestResponse<List<CommentDto>> getByProductId(Long productId) {
		
		List<Comment> comments = commentRepository.findByProductId(productId);
		List<CommentDto> commentDtos = CommentMapper.INSTANCE.converToCommentDtos(comments);
		return RestResponse.success(commentDtos);
	}

	@Override
	public RestResponse<List<CommentDto>> getByProductIdAndDates(Long productId, Date firstCommentDate,
			Date lastCommentDate) {
		
		List<Comment> comments = commentRepository.findByProductIdAndCommentDateBetween(productId, firstCommentDate, lastCommentDate);
		List<CommentDto> commentDtos = CommentMapper.INSTANCE.converToCommentDtos(comments);
		return RestResponse.success(commentDtos);
	}

	@Override
	public RestResponse<List<CommentDto>> getByUserId(Long userId) {
		
		List<Comment> comments = commentRepository.findByUserId(userId);
		List<CommentDto> commentDtos = CommentMapper.INSTANCE.converToCommentDtos(comments);
		return RestResponse.success(commentDtos);
	}

	@Override
	public RestResponse<List<CommentDto>> getByUserIdAndDates(Long userId, Date firstCommentDate, Date lastCommentDate) {
		
		List<Comment> comments = commentRepository.findByUserIdAndCommentDateBetween(userId, firstCommentDate, lastCommentDate);
		List<CommentDto> commentDtos = CommentMapper.INSTANCE.converToCommentDtos(comments);
		return RestResponse.success(commentDtos);
	}

	@Override
	public RestResponse<CommentDto> getById(Long id) {
		
		Comment comment = findById(id);
		CommentDto commentDto = CommentMapper.INSTANCE.convertToCommentDto(comment);
		return RestResponse.success(commentDto);
	}

	@Override
	public RestResponse<Void> delete(Long id) {
		
		Comment comment = findById(id);
		commentRepository.delete(comment);
		return RestResponse.empty();
		
	}
	
	private Comment findById(Long id) {
		return commentRepository.findById(id).orElseThrow(()-> new ItemNotFoundException(ErrorMessages.ITEM_NOT_FOUND.toString()));
	}

}
