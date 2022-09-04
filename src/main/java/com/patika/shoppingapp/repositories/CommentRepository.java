package com.patika.shoppingapp.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patika.shoppingapp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findByProductId(long productId);
	
	List<Comment> findByProductIdAndCommentDateBetween(long productId, Date firstCommentDate, Date lastCommentDate);
	
	List<Comment> findByUserId(Long userId);
	
	List<Comment> findByUserIdAndCommentDateBetween(long productId, Date firstCommentDate, Date lastCommentDate);
}
