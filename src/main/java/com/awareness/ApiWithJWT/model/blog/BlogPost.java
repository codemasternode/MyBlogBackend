package com.awareness.ApiWithJWT.model.blog;


import com.awareness.ApiWithJWT.model.overalls.Post;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "blog_posts")
public class BlogPost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(mappedBy = "tutorials")
    private Set<BlogComment> comments = new HashSet<>();

    public BlogPost() {
    }

    public BlogPost(String title, String imageUrl, String content, Set<BlogComment> comments) {
        super(title, imageUrl, content);
        this.comments = comments;
    }
}
