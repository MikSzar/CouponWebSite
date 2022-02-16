package com.project.coupon.service.test;

import static org.mockito.Mockito.verify;
import com.project.coupon.model.User;
import com.project.coupon.repository.UserRepository;
import com.project.coupon.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @MockBean
    UserRepository mockRepo;

    @InjectMocks
    UserService service;

    @Test
    public void testUserService_findUserById() {
        User expecteduser = new User("Walter","White");
        expecteduser.setUserId(1);
        service.findUserById(expecteduser.getUserId());

        verify(mockRepo).findById(expecteduser.getUserId());
    }
}
