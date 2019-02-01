package com.trucdeouf.dao;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.trucdeouf.entities.Post;

@RepositoryRestResource
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

	List<Post> findAllByOrderByCreateDateDesc();

}
