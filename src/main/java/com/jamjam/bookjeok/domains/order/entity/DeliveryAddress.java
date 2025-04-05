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
@Table(name = "delivery_address")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryAddress {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_address_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_uid", nullable = false)
    private Member member;

    @Column(name = "recipient_name", length = 100, nullable = false)
    private String recipientName;

    @Column(name = "recipient_phone", length = 11, nullable = false)
    private String recipientPhone;

    @Column(name = "delivery_address_category", nullable = false)
    private String deliveryAddressCategory;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "address_detail", length = 60, nullable = false)
    private String addressDetail;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "request_note", nullable = false)
    private String requestNote;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @Builder
    public DeliveryAddress(
            Member member, String recipientName, String recipientPhone,
            String deliveryAddressCategory, String address, String addressDetail,
            String postalCode, String requestNote, LocalDateTime createdAt,
            LocalDateTime modifiedAt, boolean isDeleted
    ) {
        this.member = member;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.deliveryAddressCategory = deliveryAddressCategory;
        this.address = address;
        this.addressDetail = addressDetail;
        this.postalCode = postalCode;
        this.requestNote = requestNote;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.isDeleted = isDeleted;
    }

}