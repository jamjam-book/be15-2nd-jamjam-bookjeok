package com.jamjam.bookjeok.domains.coupon.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "coupons")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Column(name = "coupon_name", nullable = false)
    private String couponName;

    @Column(name = "coupon_detail", nullable = false)
    private String couponDetail;

    @Column(name = "coupon_started_at", nullable = false)
    private LocalDateTime couponStartedAt;

    @Column(name = "coupon_expired_at", nullable = false)
    private LocalDateTime couponExpiredAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;

    @Builder
    public Coupon(
            String couponName, String couponDetail,
            LocalDateTime couponStartedAt, LocalDateTime couponExpiredAt, boolean deleted
    ) {
        this.couponName = couponName;
        this.couponDetail = couponDetail;
        this.couponStartedAt = couponStartedAt;
        this.couponExpiredAt = couponExpiredAt;
        this.deleted = deleted;
    }

}