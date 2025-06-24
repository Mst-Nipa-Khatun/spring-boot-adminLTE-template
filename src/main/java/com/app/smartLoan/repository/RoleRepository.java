package com.app.smartLoan.repository;

import com.app.smartLoan.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    long countByNameAndStatus(String roleName, Integer status);

    Role findByNameAndStatus(String roleName,Integer status);
}
