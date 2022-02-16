package com.project.coupon.controller;

import com.project.coupon.exception.CouponNotFoundException;
import com.project.coupon.exception.UserNotFoundException;
import com.project.coupon.model.Coupon;
import com.project.coupon.model.User;
import com.project.coupon.service.IUserService;
import com.project.coupon.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class UserController {

    @Autowired
    IUserService service;
    @Autowired
    ICouponService couponservice;


    @GetMapping("/")
    public String goToIndexPage() {
        return "index";
    }


    @GetMapping("/success")
    public String CheckCoupon(@RequestParam  Integer userId, @RequestParam Integer couponId){
        boolean check = service.checkCoupon(couponId, userId);

        if(check){
            return "success";
        }else {
            return "fail";
        }
    }
    @PostMapping("/success")
    public String redeemCoupon(@RequestParam Integer couponId){
        Coupon coupon = couponservice.findCouponById(couponId);
        coupon.setRemaintimes(coupon.getRemaintimes()-1);
        couponservice.save(coupon);
        return "index";
    }

    @GetMapping("/details")
    public String goToDetails(ModelMap model, @RequestParam Integer userId) {
        User user = service.findUserById(userId);

        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/details_coupon")
    public String goToCoupon(ModelMap model, @RequestParam Integer couponId) {
        Coupon coupon = couponservice.findCouponById(couponId);

        model.addAttribute("coupon", coupon);
        return "details_coupon";
    }


    @ExceptionHandler(CouponNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ModelAndView couponNotFound(CouponNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("CouponNotFound");
        return modelAndView;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ModelAndView userNotFound(UserNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("UserNotFound");
        return modelAndView;
    }

}
