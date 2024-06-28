package io.indpro.blogplateform.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.indpro.blogplateform.entities.Comment;
import io.indpro.blogplateform.payloads.CommentDto;
import io.indpro.blogplateform.services.CommentService;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentDto addComment(@PathVariable(value="postId") Long postId, @RequestBody CommentDto commentdto) {
        return commentService.addComment(postId, commentdto);
    }

    @GetMapping
    public List<CommentDto> getCommentsForPost(@PathVariable Long postId) {
        return commentService.getAllCommentsForPost(postId);
    }
}