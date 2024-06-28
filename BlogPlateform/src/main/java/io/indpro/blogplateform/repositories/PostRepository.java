package io.indpro.blogplateform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.indpro.blogplateform.entities.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
