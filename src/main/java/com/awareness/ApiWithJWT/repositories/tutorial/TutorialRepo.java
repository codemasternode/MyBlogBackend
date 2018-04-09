package com.awareness.ApiWithJWT.repositories.tutorial;

import com.awareness.ApiWithJWT.model.tutorial.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepo extends JpaRepository<Tutorial,Long> {
    List<Tutorial> findAll();
    List<Tutorial> findFirst6ByOrderByCreatedAtDesc();
}
