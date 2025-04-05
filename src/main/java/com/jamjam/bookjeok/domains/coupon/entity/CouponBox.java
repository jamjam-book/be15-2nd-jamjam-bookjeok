package com.jamjam.bookjeok.domains.coupon.entity;

import com.jamjam.bookjeok.domains.member.entity.Member;
import com.jamjam.bookjeok.domains.order.entity.Order;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member_coupon_boxs")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponBox {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_coupon_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_uid", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", nullable = false)
    private Coupon coupon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_uid", nullable = false)
    private Order order;

    @Column(name = "is_used", nullable = false)
    private boolean isUsed = false;

    public CouponBox(
            Member member, Coupon coupon,
            Order order, boolean isUsed
    ) {
        this.member = member;
        this.coupon = coupon;
        this.order = order;
        this.isUsed = isUsed;
    }

}