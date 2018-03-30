package com.awareness.ApiWithJWT.model.blog;

import com.awareness.ApiWithJWT.model.overalls.Category;
import com.awareness.ApiWithJWT.model.tutorial.Tutorial;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "blog_categories")
public class BlogCategory extends Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "blogCategory",cascade = CascadeType.ALL)
    private Set<BlogPost> tutorialSet = new HashSet<>();

    public BlogCategory() {
    }

    public BlogCategory(String name) {
        super(name);
        this.tutorialSet = tutorialSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BlogPost> getTutorialSet() {
        return tutorialSet;
    }

    public void setTutorialSet(Set<BlogPost> tutorialSet) {
        this.tutorialSet = tutorialSet;
    }
}
