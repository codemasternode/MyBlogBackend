package com.awareness.ApiWithJWT.model.overalls;

import com.awareness.ApiWithJWT.model.User;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@MappedSuperclass
public abstract class Comment implements Serializable{

    @ManyToOne
    private User user;

    @NotBlank
    private String content;

    public Comment() {
    }

    public Comment(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
