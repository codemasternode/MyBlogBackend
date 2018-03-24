package com.awareness.ApiWithJWT.model.blog;

import com.awareness.ApiWithJWT.model.overalls.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "blog_comments")
public class BlogComment extends Comment {
}
