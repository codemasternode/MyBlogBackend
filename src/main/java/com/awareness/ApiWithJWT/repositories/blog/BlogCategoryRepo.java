package com.awareness.ApiWithJWT.repositories.blog;

import com.awareness.ApiWithJWT.model.blog.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCategoryRepo extends JpaRepository<BlogCategory,Long>{
}
