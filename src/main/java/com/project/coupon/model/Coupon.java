package com.project.coupon.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue
    private Integer couponId;

    private Double value;
    private Integer remaintimes;

    public Coupon() {

    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getRemaintimes() {
        return remaintimes;
    }

    public void setRemaintimes(Integer remaintimes) {
        this.remaintimes = remaintimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon)) return false;
        Coupon coupon = (Coupon) o;
        return getCouponId().equals(coupon.getCouponId()) && getValue().equals(coupon.getValue()) && getRemaintimes().equals(coupon.getRemaintimes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCouponId(), getValue(), getRemaintimes());
    }

    public Coupon(Double value, Integer remaintimes) {
        this.value = value;
        this.remaintimes = remaintimes;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId=" + couponId +
                ", value=" + value +
                ", remaintimes=" + remaintimes +
                '}';
    }
}
