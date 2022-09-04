package com.patika.shoppingapp.entities;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@RequiredArgsConstructor
public class User {
	
	@Id
	@SequenceGenerator(name = "user", sequenceName = "USER_ID_SEQUENCE",  allocationSize = 1)
	@GeneratedValue(generator = "user", strategy  = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String firstName;
	
	@Column(length = 50, nullable = false)
	private String lastName;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 15, nullable = false)
	private String phoneNumber;
	
	@OneToMany(mappedBy = "user")
	private Set<Comment> comments;
}
