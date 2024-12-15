package com.enterprise.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.domain.Post;
import com.enterprise.repository.PostRepository;
import com.enterprise.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository PostRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = PostRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public List<Post> findByTitle(String text) {
		return PostRepository.findByTitle(text);
	}
	

}
