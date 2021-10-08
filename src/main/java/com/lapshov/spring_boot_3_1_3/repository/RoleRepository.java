package com.lapshov.spring_boot_3_1_3.repository;

import com.lapshov.spring_boot_3_1_3.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String role);

}