package com.awareness.ApiWithJWT.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "blog_posts")
public class BlogPost extends Post{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(mappedBy = "tutorials")
    private Set<Comment> comments = new HashSet<>();

    public BlogPost() {
    }

    public BlogPost(String title, String imageUrl, String content, Set<Comment> comments) {
        super(title, imageUrl, content);
        this.comments = comments;
    }
}
