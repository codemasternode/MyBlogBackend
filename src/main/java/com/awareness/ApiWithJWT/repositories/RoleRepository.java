package com.awareness.ApiWithJWT.repositories;


import com.awareness.ApiWithJWT.model.Role;
import com.awareness.ApiWithJWT.model.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
