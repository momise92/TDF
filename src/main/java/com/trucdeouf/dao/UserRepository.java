package com.trucdeouf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trucdeouf.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
