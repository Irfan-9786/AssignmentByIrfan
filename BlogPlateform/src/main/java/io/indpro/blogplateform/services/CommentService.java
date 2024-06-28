package io.indpro.blogplateform.services;

import java.util.List;

import io.indpro.blogplateform.entities.Comment;
import io.indpro.blogplateform.payloads.CommentDto;

public interface CommentService {
public CommentDto addComment(Long postId,CommentDto commentdto);
public List<CommentDto> getAllCommentsForPost(Long postId);
}
