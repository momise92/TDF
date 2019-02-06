package com.trucdeouf.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.trucdeouf.entities.Post;

@RepositoryRestResource
public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findAllByOrderByCreateDateDesc();

}
