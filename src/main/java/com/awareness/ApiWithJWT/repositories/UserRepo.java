package com.awareness.ApiWithJWT.repositories;

import com.awareness.ApiWithJWT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
}
