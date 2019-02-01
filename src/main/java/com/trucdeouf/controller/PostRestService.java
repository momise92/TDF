/*package com.trucdeouf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trucdeouf.dao.PostRepository;
import com.trucdeouf.entities.Post;

import net.bytebuddy.implementation.bytecode.Throw;


@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class PostRestService {
	
	@Autowired
	private PostRepository postRepository;

	@RequestMapping(value = "posts", method = RequestMethod.GET)
	public List<Post> getAllPosts() {

		return postRepository.findAllByOrderByCreateDateDesc();
	}
		
	@RequestMapping(value = "post/{id}", method = RequestMethod.GET)
	Post getPost(@PathVariable Long id) throws Throwable {
			return postRepository.findById(id)
					.orElseThrow(() -> new Throwable("Ce post n'existe pas"));
			}

	 @RequestMapping(value = "/simplante/{id}", method = RequestMethod.GET)
	public Simplante getSimplante(@PathVariable Long id) {

		Simplante result = null;

		if (simplanteRepository.findById(id).isPresent()) {
			result = simplanteRepository.findById(id).get();
		}
		return result;
	} 
	

	@PostMapping(value = "posts")
	public Post publishPost(@RequestBody Post post) {
		return postRepository.save(post);
	}

	@RequestMapping(value = "post/{id}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable Long id) {
		postRepository.deleteById(id);
		return true;
	}

	@RequestMapping(value = "post/{id}", method = RequestMethod.PUT)
	public Post save(@PathVariable Long id, @RequestBody Post s) {
		s.setId(id);
		return postRepository.save(s);
	}
}
*/