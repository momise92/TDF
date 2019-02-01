package com.trucdeouf.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Post {
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	@Column(name = "post_id")
	private Long id;
	
	@Column(nullable = false)
    @Length(min = 5, max = 50, message = "*Your title must have at least 5 characters")
	private String title;
	
	@Column(nullable = false)
	private String body;
	
	@Column(name = "create_date")
	private LocalDateTime createDate = LocalDateTime.now();
	 
	private int vote;
	
	@ManyToOne
    private User user;
	
	@ManyToOne 
	@JoinColumn(name = "categorie_id", referencedColumnName = "categorie_id")
	private Categorie categorie;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Collection<Comment> comments;

	
	public Post(@Length(min = 5, max = 50, message = "*Your title must have at least 5 characters") String title,
			String body, int vote, User user, Categorie categorie, Collection<Comment> comments) {
		this.title = title;
		this.body = body;
		this.vote = vote;
		this.user = user;
		this.categorie = categorie;
		this.comments = comments;
	}
	

}
