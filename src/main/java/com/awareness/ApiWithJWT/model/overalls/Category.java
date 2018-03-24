package com.awareness.ApiWithJWT.model;

import com.awareness.ApiWithJWT.model.overalls.Note;
import com.awareness.ApiWithJWT.model.overalls.Post;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Note> posts = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Note> getPosts() {
        return posts;
    }

    public void setPosts(Set<Note> posts) {
        this.posts = posts;
    }
}
