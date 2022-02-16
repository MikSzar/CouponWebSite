package com.project.coupon.controller.test;

import com.project.coupon.controller.UserController;
import com.project.coupon.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;



@SpringBootTest(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @MockBean
    private IUserService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_CheckCoupon() throws Exception{




    }

    /*@Test
    public void test_RedeemCoupon() throws Exception {
        Coupon expectedCoupon = new Coupon(20.0,3);

        mockMvc.perform(post("/success"))
                .andExpect(model().attribute("coupon", expectedCoupon))
                .andExpect(view().name("index"));
        Assert.assertEquals(java.util.Optional.of(2), expectedCoupon.getRemaintimes());
    }*/
}
