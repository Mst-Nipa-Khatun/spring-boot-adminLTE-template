package com.app.smartLoan;

import com.app.smartLoan.dto.UserDto;
import com.app.smartLoan.dto.Response;
import com.app.smartLoan.service.Impl.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SmartLoanApplicationTests {

	@Autowired
	private AuthService authService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	/*	int a=6;
		int b=7;

		assertTrue(a==b);*/
	}
	@Test
	void testAgro() {
		UserDto usersDto=new UserDto();
		usersDto.setUsername("Nipa");
		usersDto.setPhone("0123454");
		usersDto.setEmail("nipa@gmail.com");
		usersDto.setPassword(passwordEncoder.encode("1234"));

		Response response = authService.register(usersDto);
		assertTrue(response.getStatusCode()==201);

		/*if(response.getStatusCode()==201){
			System.out.println("Successfully registered user");
		}else {
			System.out.println("error");
		}*/

	}

}
