package com.project.coupon.service;

import com.project.coupon.exception.CouponNotFoundException;
import com.project.coupon.exception.UserNotFoundException;
import com.project.coupon.model.Coupon;
import com.project.coupon.model.User;
import com.project.coupon.repository.CouponRepository;
import com.project.coupon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public User findUserById(Integer userId) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isPresent())
            return optUser.get();
        else
            throw new UserNotFoundException(userId);
    }
    @Override
    public Set<Coupon> getUserCoupons(Integer userId){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent())
            return user.get().getCoupons();
        else
            throw new UserNotFoundException(userId);
    }
    @Override
    public boolean checkCoupon(Integer couponId, Integer userId){
        Optional<User> optUser = userRepository.findById(userId);
        Optional<Coupon> optCoupon =  couponRepository.findById(couponId);
        if (optUser.isPresent() && optCoupon.isPresent()) {
            User user = optUser.get();
            Coupon coupon = optCoupon.get();
            return user.getCoupons().contains(coupon) && coupon.getRemaintimes() >= 1;
        }
        else {
            throw new CouponNotFoundException(couponId);
        }
    }
}
