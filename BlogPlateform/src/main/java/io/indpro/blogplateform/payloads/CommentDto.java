package io.indpro.blogplateform.payloads;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.indpro.blogplateform.entities.Post;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CommentDto {
	    private Long id;
	    private Long author_id;
	    private String content;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	    private Timestamp created_at;
		public CommentDto() {
			super();
		}
		public CommentDto(Long id, Long author_id, String content, Timestamp created_at) {
			super();
			this.id = id;
			this.author_id = author_id;
			this.content = content;
			this.created_at = created_at;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getAuthor_id() {
			return author_id;
		}
		public void setAuthor_id(Long author_id) {
			this.author_id = author_id;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Timestamp getCreated_at() {
			return created_at;
		}
		public void setCreated_at(Timestamp created_at) {
			this.created_at = created_at;
		}
	    
}
