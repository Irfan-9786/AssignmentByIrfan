package io.indpro.blogplateform.services.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.indpro.blogplateform.entities.Post;
import io.indpro.blogplateform.repositories.PostRepository;
import io.indpro.blogplateform.services.PostService;
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	@Override
	public Post createPost(Post post) {
		post.setCreated_at(new Timestamp(System.currentTimeMillis()));
		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		
		return postRepository.findAll();
	}

}
