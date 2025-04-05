package com.jamjam.bookjeok.domains.point.entity;

import com.jamjam.bookjeok.domains.member.entity.Member;
import com.jamjam.bookjeok.domains.order.entity.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "points")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Point {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_save_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_uid", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_uid", nullable = false)
    private Order order;

    @Column(name = "save_status", nullable = false)
    private boolean saveStatus;

    @Column(name = "save_amount", nullable = false)
    private int saveAmount;

    @Column(name = "saved_at", nullable = false)
    private LocalDateTime savedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;

    @Builder
    public Point(
            Member member, Order order, boolean saveStatus,
            int saveAmount, LocalDateTime savedAt, LocalDateTime createdAt,
            LocalDateTime modifiedAt, boolean deleted
    ) {
        this.member = member;
        this.order = order;
        this.saveStatus = saveStatus;
        this.saveAmount = saveAmount;
        this.savedAt = savedAt;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deleted = deleted;
    }

}