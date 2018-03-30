package com.awareness.ApiWithJWT.model.blog;


import com.awareness.ApiWithJWT.model.overalls.Post;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "blog_posts")
public class BlogPost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "blogPost",cascade = CascadeType.ALL)
    private Set<BlogComment> comments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "blog_category_id")
    private BlogCategory blogCategory;

    public BlogPost() {
    }

    public BlogPost(String title, String imageUrl, String content, BlogCategory blogCategory) {
        super(title, imageUrl, content);
        this.blogCategory = blogCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BlogComment> getComments() {
        return comments;
    }

    public void setComments(Set<BlogComment> comments) {
        this.comments = comments;
    }

    public BlogCategory getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(BlogCategory blogCategory) {
        this.blogCategory = blogCategory;
    }
}
