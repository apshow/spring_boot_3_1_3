package com.lapshov.spring_boot_3_1_3.repository;

import com.lapshov.spring_boot_3_1_3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);

    User getUserById(long id);

    // boolean existsById(long id);
}
