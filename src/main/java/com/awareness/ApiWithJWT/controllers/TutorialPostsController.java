package com.awareness.ApiWithJWT.controllers;


import com.awareness.ApiWithJWT.model.tutorial.Tutorial;
import com.awareness.ApiWithJWT.payloads.ApiRespone;
import com.awareness.ApiWithJWT.repositories.tutorial.TutorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tutorials")
public class TutorialPostsController {

    @Autowired
    private TutorialRepo tutorialRepo;

    @GetMapping("/all")
    @ResponseBody
    public List<Tutorial> all(){
        List<Tutorial> tutorials = tutorialRepo.findAll();
        System.out.println(tutorials);
        return tutorials;
    }
}
