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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 30)
    private String username;

    @NotBlank
    @Email
    @Size(max = 50)
    @NaturalId
    private String email;

    @NotBlank
    @Size(min = 6, max = 35)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> userRole = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<BlogComment> blogComments = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<TutorialComment> tutorialComments = new HashSet<>();

    private boolean enabled = true;

    public User() {
    }

    public User(String name, String username,  String email, String password, boolean enabled) {
        this.name = name;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
