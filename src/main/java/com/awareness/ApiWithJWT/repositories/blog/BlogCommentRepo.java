package com.awareness.ApiWithJWT.repositories.blog;

import com.awareness.ApiWithJWT.model.blog.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCommentRepo extends JpaRepository<BlogComment,Long>{
}
