package com.awareness.ApiWithJWT.repositories.tutorial;

import com.awareness.ApiWithJWT.model.tutorial.TutorialCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialCategoryRepo extends JpaRepository<TutorialCategory,Long>{
    TutorialCategory getByName(String java);
}
