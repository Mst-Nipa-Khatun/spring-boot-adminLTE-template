package com.app.smartLoan.service.Impl;

import com.app.smartLoan.dto.UserDto;
import com.app.smartLoan.repository.RoleRepository;
import com.app.smartLoan.repository.UserRepository;
import com.app.smartLoan.service.UserService;
import com.app.smartLoan.dto.Response;
import com.app.smartLoan.entity.Role;
import com.app.smartLoan.entity.User;
import com.app.smartLoan.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Response userRegister(UserDto userDto) {
        if (userDto.getUsername() == null || userDto.getUsername().trim().isEmpty())
        {
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
                    "Username should not be empty");
        }
        User user = userRepository.findByPhoneAndStatus(userDto.getPhone(), 1);
        if (user != null) {
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,
                    null, "This Phone number already exists");
        }
        Role role = roleRepository.findByNameAndStatus("ROLE_USER", 1);
        if (role == null) {
            role = new Role();
            role.setName("ROLE_USER");
            role.setStatus(1);
            role = roleRepository.save(role);
        }
        user = new User();
        user.setName(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        String encodePass=passwordEncoder.encode(userDto.getPassword());
        user.setPasswordHash(encodePass);
        user.setStatus(1);

        List<Role> roles = Arrays.asList(role);
        user.setRoles(roles);
        User savedUser = userRepository.save(user);

        return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, savedUser,
                "User registered successfully");
    }
}
