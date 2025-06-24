package com.app.smartLoan.service;

import com.app.smartLoan.dto.UserDto;
import com.app.smartLoan.dto.Response;

public interface UserService {
    Response userRegister(UserDto userDto);
}
