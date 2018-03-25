package com.awareness.ApiWithJWT.repositories.blog;

import com.awareness.ApiWithJWT.model.blog.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepo extends JpaRepository<BlogPost,Long> {
}
