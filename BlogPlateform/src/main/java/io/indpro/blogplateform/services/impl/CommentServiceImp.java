package io.indpro.blogplateform.services.impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.indpro.blogplateform.entities.Comment;
import io.indpro.blogplateform.entities.Post;
import io.indpro.blogplateform.exceptions.ResourceNotFoundException;
import io.indpro.blogplateform.payloads.CommentDto;
import io.indpro.blogplateform.repositories.CommentRepository;
import io.indpro.blogplateform.repositories.PostRepository;
import io.indpro.blogplateform.services.CommentService;

@Service
public class CommentServiceImp implements CommentService{
@Autowired
private CommentRepository commentRepository;
@Autowired
private PostRepository postRepository;
@Autowired
private ModelMapper modelMapper;
	@Override
	public CommentDto addComment(Long postId, CommentDto commentdto) {
		
		Post post=this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found with id : "+postId));
		Comment comment=this.modelMapper.map(commentdto, Comment.class);
		comment.setPost(post);
		comment.setCreated_at(new Timestamp(System.currentTimeMillis()));
		
		Comment comment2=commentRepository.save(comment);
	return this.modelMapper.map(comment2, CommentDto.class);
	}

	@Override
	public List<CommentDto> getAllCommentsForPost(Long postId) {
		
		List<Comment> comments= commentRepository.findByPostId(postId);
		List<CommentDto> commentDtos=comments.stream().map(comment->this.modelMapper.map(comment,CommentDto.class)).collect(Collectors.toList());
     	return commentDtos;
	}

}
