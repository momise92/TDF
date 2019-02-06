package com.trucdeouf.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trucdeouf.dao.PostRepository;
import com.trucdeouf.entities.Post;

@RepositoryRestController
@BasePathAwareController
public class PostRestService {
	
	@Autowired
	private PostRepository postRepository;

	/*@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public List<Post> getAllPosts() {

		return postRepository.findAllByOrderByCreateDateDesc();
	}
		
	@GetMapping(value = "posts/{id}")
	Post getPost(@PathVariable Long id) throws Throwable {
			return postRepository.findById(id)
					.orElseThrow(() -> new Throwable("Ce post n'existe pas"));
			}*/
	
	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Post post) {
		post.setLastModified(LocalDateTime.now());
		return new ResponseEntity<Post>(postRepository.save(post), HttpStatus.CREATED);
	}
	
	/*@RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable Long id) {
		postRepository.deleteById(id);
		return true;
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
	public Post update(@RequestBody Post post) {
		return postRepository.save(post);
	}*/

}
