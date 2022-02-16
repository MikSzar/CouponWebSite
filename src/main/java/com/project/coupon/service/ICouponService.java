package com.project.coupon.service;

import com.project.coupon.model.Coupon;


public interface ICouponService {

    void save(Coupon coupon);

    Coupon findCouponById(Integer couponId);

    void deleteCouponById(Integer couponId);
}
