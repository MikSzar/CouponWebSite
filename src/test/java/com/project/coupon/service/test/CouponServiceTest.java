package com.project.coupon.service.test;

import static org.mockito.Mockito.verify;
import com.project.coupon.model.Coupon;
import com.project.coupon.repository.CouponRepository;
import com.project.coupon.service.CouponService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CouponServiceTest {

    @MockBean
    CouponRepository mockRepo;

    @InjectMocks
    CouponService service;

    @Test
    public void testCouponService_findCouponById() {
        Coupon expectedcoupon = new Coupon(10.0,3);
        expectedcoupon.setCouponId(1);
        service.findCouponById(expectedcoupon.getCouponId());
        verify(mockRepo).findById(expectedcoupon.getCouponId());
    }

    @Test
    public void testCouponService_deleteCouponById() {
        List<Coupon> expectedCoupon = new ArrayList<>();
        expectedCoupon.add(new Coupon(2.0,4));
        Coupon coupon = new Coupon(2.0,4);
        Mockito.verify(mockRepo).delete(coupon);
    }

}