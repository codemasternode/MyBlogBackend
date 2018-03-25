package com.awareness.ApiWithJWT.model.tutorial;

import com.awareness.ApiWithJWT.model.User;
import com.awareness.ApiWithJWT.model.overalls.Comment;

import javax.persistence.*;

@Entity
@Table(name = "tutorial_comments")
public class TutorialComment extends Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    private Tutorial tutorial;

    public TutorialComment() {
    }

    public TutorialComment(User user, String content, Tutorial tutorial) {
        super(user, content);
        this.tutorial = tutorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }
}
