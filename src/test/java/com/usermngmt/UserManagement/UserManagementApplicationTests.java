package com.usermngmt.UserManagement;

import com.usermngmt.UserManagement.Controller.UserController;
import com.usermngmt.UserManagement.Model.User;
import com.usermngmt.UserManagement.Repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserManagementApplicationTests {

	@InjectMocks
	UserController userController;

	@Mock
	UserRepository userRepository;


	@BeforeEach
	void initUseCase() {
		userController = new UserController(userRepository);
	}


}
