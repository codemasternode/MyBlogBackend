package com.awareness.ApiWithJWT.model.blog;

import com.awareness.ApiWithJWT.model.User;
import com.awareness.ApiWithJWT.model.overalls.Comment;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "blog_comments")
public class BlogComment extends Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blog_post_id")
    private BlogPost blogPost;

    public BlogComment() {
    }

    public BlogComment(User user, String content, BlogPost blogPost) {
        super(user, content);
        this.blogPost = blogPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }
}
