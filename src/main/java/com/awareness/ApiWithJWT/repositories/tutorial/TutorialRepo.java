package com.awareness.ApiWithJWT.repositories.tutorial;

import com.awareness.ApiWithJWT.model.tutorial.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorialRepo extends JpaRepository<Tutorial,Long> {

}
