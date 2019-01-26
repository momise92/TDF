package com.trucdeouf.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Post {
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;
	
	@Column(nullable = false)
    @Length(min = 5, max = 50, message = "*Your title must have at least 5 characters")
	private String title;
	
	@Column(nullable = false)
	private String body;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	 
	private int vote;
	
	@ManyToOne
    private User author;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Collection<Comment> comments;

	public Post(@Length(min = 5, max = 50, message = "*Your title must have at least 5 characters") String title,
			String body, LocalDateTime createDate, int vote, User author) {
		this.title = title;
		this.body = body;
		this.createDate = createDate;
		this.vote = vote;
		this.author = author;
	}
	
	

}
