package com.project.coupon.service;

import com.project.coupon.exception.CouponNotFoundException;
import com.project.coupon.model.Coupon;
import com.project.coupon.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponService implements ICouponService{

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public void save(Coupon coupon) {
        couponRepository.save(coupon);
    }

    @Override
    public Coupon findCouponById(Integer couponId) {
        Optional<Coupon> optCoupon = couponRepository.findById(couponId);
        if (optCoupon.isPresent())
            return optCoupon.get();
        else
            throw new CouponNotFoundException(couponId);
    }

    @Override
    public void deleteCouponById(Integer couponId) {
        couponRepository.delete(findCouponById(couponId));
    }
}
