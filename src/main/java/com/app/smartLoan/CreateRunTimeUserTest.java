package com.app.smartLoan;


import com.app.smartLoan.entity.Role;
import com.app.smartLoan.entity.User;
import com.app.smartLoan.repository.RoleRepository;
import com.app.smartLoan.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CreateRunTimeUserTest {
    private static final Logger logger = LoggerFactory.getLogger(CreateRunTimeUserTest.class.getName());
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private String phone = "01754297677";

    private String password = "1234";

    public CreateRunTimeUserTest(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostConstruct
    public void test() {
        String roleName = "ROLE_ADMIN";
        long roleExistCount = roleRepository.countByNameAndStatus(roleName,1);
        Role role = null;
        if (roleExistCount > 0) {
            role = roleRepository.findByNameAndStatus(roleName,1);
        } else {
            role = new Role();
            role.setStatus(1);
            role.setName(roleName);
            role = roleRepository.save(role);
        }
        User user = userRepository.findByPhoneAndStatus(phone,1);
        if (user == null) {
            user = new User();
            user.setCreatedBy("RunTimeUser");
            user.setName("Golam Kibria");
            user.setPasswordHash(passwordEncoder.encode(password));
            user.setPhone(phone);
            user.setStatus(1);
            user.setEmail("kibria.java@gmail.com");
        }

        user.setRoles(Collections.singletonList(role));
        user = userRepository.save(user);
    }
}
