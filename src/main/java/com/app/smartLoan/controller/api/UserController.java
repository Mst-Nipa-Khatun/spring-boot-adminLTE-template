package com.app.smartLoan.controller.api;

import com.app.smartLoan.dto.UserDto;
import com.app.smartLoan.service.UserService;
import com.app.smartLoan.dto.Response;
import com.app.smartLoan.utils.UrlConstraint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstraint.Users.ROOT)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(UrlConstraint.Users.CREATE)
    public Response userRegister(@RequestBody UserDto userDto) {
        return userService.userRegister(userDto);
    }

}
