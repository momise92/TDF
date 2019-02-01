package com.trucdeouf.entities;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "create_date", nullable = false, updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();

	@Column(unique = true, nullable = false)
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(name = "password", nullable = false)
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@JsonIgnore
	private String password;

	@Column(name = "username", nullable = false, unique = true)
	@Length(min = 4, max = 20, message = "*Your username must have at least 4 characters")
	@NotEmpty(message = "*Please provide your name")
	private String username;

	@NotEmpty(message = "*Please provide your name")
	private String name;

	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Column(name = "active", nullable = false)
	private Boolean active;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Collection<Post> posts;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Collection<Comment> comments;

	public User(
			@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email,
			@Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password,
			@Length(min = 4, max = 20, message = "*Your username must have at least 4 characters") @NotEmpty(message = "*Please provide your name") String username,
			@NotEmpty(message = "*Please provide your name") String name,
			@NotEmpty(message = "*Please provide your last name") String lastName, Boolean active,
			Collection<Post> posts, Set<Role> roles, Collection<Comment> comments) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.posts = posts;
		this.roles = roles;
		this.comments = comments;
	}

}
