package io.indpro.blogplateform.services;

import java.util.List;

import io.indpro.blogplateform.entities.Post;

public interface PostService {
public Post createPost(Post post);
public List<Post> getAllPosts();
}
