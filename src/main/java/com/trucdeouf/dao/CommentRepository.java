package com.trucdeouf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.trucdeouf.entities.Comment;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
