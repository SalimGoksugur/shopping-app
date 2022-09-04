package com.patika.shoppingapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.patika.shoppingapp.dtos.CommentDto;
import com.patika.shoppingapp.dtos.CreateCommentDto;
import com.patika.shoppingapp.entities.Comment;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CommentMapper {
	
	CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
	
	CommentDto convertToCommentDto(Comment comment);
		
	Comment convertToComment (CreateCommentDto createCommentDto);
	
	List<CommentDto> converToCommentDtos(List<Comment> commemnts);
	

}
