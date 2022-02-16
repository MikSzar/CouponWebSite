package com.project.coupon.service;

import com.project.coupon.model.Coupon;
import com.project.coupon.model.User;

import java.util.Set;

public interface IUserService {

    User findUserById(Integer userId);
    Set<Coupon> getUserCoupons(Integer userId);
    boolean checkCoupon(Integer coupon, Integer userId);
}
