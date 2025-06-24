package com.app.smartLoan.service.Impl;

import com.app.smartLoan.config.UserPrincipal;
import com.app.smartLoan.entity.User;
import com.app.smartLoan.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userRepository.findByPhoneAndStatus(phone, 1);
        if (user == null) {
            throw new UsernameNotFoundException("Phone Number Not Found");
        }
        UserPrincipal userDetails = UserPrincipal.create(user);
        if (userDetails == null) {
            throw new UsernameNotFoundException("Phone Number Not Found");
        }
        return userDetails;
    }
}