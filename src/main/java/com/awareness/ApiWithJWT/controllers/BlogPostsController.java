package com.awareness.ApiWithJWT.controllers;


import com.awareness.ApiWithJWT.repositories.blog.BlogPostRepo;
import com.awareness.ApiWithJWT.repositories.tutorial.TutorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogPosts")
public class BlogPostsController {

    @Autowired
    private BlogPostRepo blogPostRepo;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(blogPostRepo.findAll());
    }

    @GetMapping("/getSixFirst")
    public ResponseEntity<?> getSixFirstRow() {
        return ResponseEntity.ok(blogPostRepo.findFirst6ByOrderByCreatedAtDesc());
    }

}
