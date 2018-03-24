package com.awareness.ApiWithJWT.model.tutorial;

import com.awareness.ApiWithJWT.model.overalls.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tutorial_comments")
public class TutorialComment extends Comment {
}
