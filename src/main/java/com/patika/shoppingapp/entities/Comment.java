package com.patika.shoppingapp.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
public class Comment {
	
	@Id
	@SequenceGenerator(name = "comment", sequenceName = "COMMENT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "comment", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String content;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date commentDate = new Date();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", updatable = false, nullable = false)
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", updatable = false, nullable = false)
	private Product product;
}
