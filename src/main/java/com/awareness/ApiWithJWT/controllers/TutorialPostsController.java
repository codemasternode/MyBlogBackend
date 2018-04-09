package com.awareness.ApiWithJWT.controllers;


import com.awareness.ApiWithJWT.model.tutorial.Tutorial;
import com.awareness.ApiWithJWT.payloads.ApiResponse;
import com.awareness.ApiWithJWT.payloads.JwtAuthenticationResponse;
import com.awareness.ApiWithJWT.payloads.LoginRequest;
import com.awareness.ApiWithJWT.repositories.tutorial.TutorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/tutorials")
public class TutorialPostsController {

    @Autowired
    private TutorialRepo tutorialRepo;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(tutorialRepo.findAll());
    }

    @GetMapping("/getSixFirst")
    public ResponseEntity<?> getSixFirstRow() {
        return ResponseEntity.ok(tutorialRepo.findFirst6ByOrderByCreatedAtDesc());
    }



}
