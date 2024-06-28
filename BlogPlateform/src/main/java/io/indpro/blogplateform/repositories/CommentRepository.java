package io.indpro.blogplateform.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.indpro.blogplateform.entities.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Serializable> {
List<Comment> findByPostId(Long postId);
}
