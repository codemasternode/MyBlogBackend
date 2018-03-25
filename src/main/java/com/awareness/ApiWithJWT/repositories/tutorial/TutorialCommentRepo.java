package com.awareness.ApiWithJWT.repositories.tutorial;

import com.awareness.ApiWithJWT.model.tutorial.TutorialComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialCommentRepo extends JpaRepository<TutorialComment,Long>{
}
