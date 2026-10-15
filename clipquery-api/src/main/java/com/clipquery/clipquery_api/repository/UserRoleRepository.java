package com.clipquery.clipquery_api.repository;

import com.clipquery.clipquery_api.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
