package com.sda.ams.repository;

import com.sda.ams.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<Role, Integer> {
}
