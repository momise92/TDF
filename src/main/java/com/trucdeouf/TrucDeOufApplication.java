package com.trucdeouf;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trucdeouf.dao.PostRepository;
import com.trucdeouf.dao.UserRepository;
import com.trucdeouf.entities.Post;

@SpringBootApplication
public class TrucDeOufApplication implements CommandLineRunner {

	@Autowired
	PostRepository postRepository;
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TrucDeOufApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new com.trucdeouf.entities.User("leboss@email.com", "password", "Hash", "Carter","mylastname",true,null));
		postRepository.save(new Post("Test1", "Ceci est mon premier test", LocalDateTime.now(), 1, null));
		postRepository.save(new Post("Test2", "Ceci est mon premier test", LocalDateTime.now(), 1, null));
	}

}

