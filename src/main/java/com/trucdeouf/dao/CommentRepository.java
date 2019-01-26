package com.trucdeouf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trucdeouf.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
