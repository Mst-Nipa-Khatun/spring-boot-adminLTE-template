package com.app.smartLoan.repository;

import com.app.smartLoan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByNameAndStatus(String name, Integer status);
    User findByPhoneAndStatus(String phone, Integer status);

    User findByIdAndStatus(Long userId, Integer status);
}
