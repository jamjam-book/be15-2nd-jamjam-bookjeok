package com.jamjam.bookjeok.domains.payment.entity;

import com.jamjam.bookjeok.domains.order.entity.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "payments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_uid", nullable = false)
    private Order order;

    @Column(
            name = "payment_key", unique = true,
            length = 200, nullable = false
    )
    private String paymentKey;

    @Column(name = "payment_type", length = 30, nullable = false)
    private String paymentType;

    @Column(name = "payment_method", length = 50, nullable = false)
    private String paymentMethod;

    @Column(name = "total_amount", nullable = false)
    private int totalAmount;

    @Column(name = "requested_at", nullable = false)
    private LocalDateTime requestedAt;

    @Column(name = "approved_at", nullable = false)
    private LocalDateTime approvedAt;

    @Column(name = "cancel_amount")
    private int cancelAmount;

    @Column(name = "canceled_at")
    private LocalDateTime canceledAt;

    @Builder
    public Payment(
            Order order, String paymentKey, String paymentType,
            String paymentMethod, int totalAmount, LocalDateTime requestedAt,
            LocalDateTime approvedAt, int cancelAmount, LocalDateTime canceledAt
    ) {
        this.order = order;
        this.paymentKey = paymentKey;
        this.paymentType = paymentType;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.requestedAt = requestedAt;
        this.approvedAt = approvedAt;
        this.cancelAmount = cancelAmount;
        this.canceledAt = canceledAt;
    }

}