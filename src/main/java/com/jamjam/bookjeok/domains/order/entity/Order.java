package com.jamjam.bookjeok.domains.order.entity;

import com.jamjam.bookjeok.domains.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_uid")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_uid", nullable = false)
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_address_id", nullable = false)
    private DeliveryAddress deliveryAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_status_id", nullable = false)
    private OrderStatus orderStatus;

    @Column(
            name = "order_code", unique = true,
            length = 16, nullable = false
    )
    private String orderCode;

    @Column(name = "order_name", nullable = false)
    private String orderName;

    @Column(name = "total_amount", nullable = false)
    private int totalAmount;

    @Column(name = "delivery_cost", nullable = false)
    private int deliveryCost;

    @Column(name = "ordered_at", nullable = false)
    private LocalDateTime orderedAt;

    @Column(name = "cancled_at")
    private LocalDateTime canceledAt;

    @Column(name = "refunded_at")
    private LocalDateTime refundedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Order(
            Member member, DeliveryAddress deliveryAddress, OrderStatus orderStatus,
            String orderCode, String orderName, int totalAmount, int deliveryCost,
            LocalDateTime orderedAt, LocalDateTime canceledAt, LocalDateTime refundedAt,
            LocalDateTime createdAt, LocalDateTime modifiedAt
    ) {
        this.member = member;
        this.deliveryAddress = deliveryAddress;
        this.orderStatus = orderStatus;
        this.orderCode = orderCode;
        this.orderName = orderName;
        this.totalAmount = totalAmount;
        this.deliveryCost = deliveryCost;
        this.orderedAt = orderedAt;
        this.canceledAt = canceledAt;
        this.refundedAt = refundedAt;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}