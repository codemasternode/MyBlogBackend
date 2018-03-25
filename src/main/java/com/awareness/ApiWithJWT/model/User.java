package com.awareness.ApiWithJWT.model;


import com.awareness.ApiWithJWT.model.blog.BlogComment;
import com.awareness.ApiWithJWT.model.overalls.Comment;
import com.awareness.ApiWithJWT.model.overalls.DateAudit;
import com.awareness.ApiWithJWT.model.tutorial.TutorialComment;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "user")
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"}),
        @UniqueConstraint(columnNames = {"surname"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 30)
    private String surname;

    @NotBlank
    @Email
    @Size(max = 50)
    @NaturalId
    private String email;

    @NotBlank
    @Size(min = 6, max = 35)
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserRole> userRole = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<BlogComment> blogComments = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<TutorialComment> tutorialComments = new HashSet<>();

    private boolean enabled = true;

    public User() {
    }

    public User(String name, String surname,  String email, String password, Set<UserRole> userRole, boolean enabled) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.enabled = enabled;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    public Set<BlogComment> getBlogComments() {
        return blogComments;
    }

    public void setBlogComments(Set<BlogComment> blogComments) {
        this.blogComments = blogComments;
    }

    public Set<TutorialComment> getTutorialComments() {
        return tutorialComments;
    }

    public void setTutorialComments(Set<TutorialComment> tutorialComments) {
        this.tutorialComments = tutorialComments;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
