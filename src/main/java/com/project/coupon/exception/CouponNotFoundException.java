package com.project.coupon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CouponNotFoundException extends RuntimeException {
    public CouponNotFoundException(int id) {
        super("The coupon with id: " + id + " could not be found.");
    }
}
