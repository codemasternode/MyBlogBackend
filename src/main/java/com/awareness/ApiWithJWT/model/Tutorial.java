package com.awareness.ApiWithJWT.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tutorials")
public class Tutorial extends Post{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "tutorials")
    private Set<Comment> comments = new HashSet<>();

    public Tutorial() {
    }

    public Tutorial(String title, String imageUrl, String content, Set<Comment> comments) {
        super(title, imageUrl, content);
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
