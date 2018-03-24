package com.awareness.ApiWithJWT.repositories;

import com.awareness.ApiWithJWT.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,Long> {
}
