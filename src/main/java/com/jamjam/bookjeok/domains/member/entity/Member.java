package com.jamjam.bookjeok.domains.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_uid")
    private Long id;

    @Column(name = "member_id", unique = true, nullable = false)
    private String memberId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "member_name", length = 100, nullable = false)
    private String memberName;

    @Column(name = "phone_number", length = 11, nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(
            name = "nickname", length = 100,
            unique = true, nullable = false
    )
    private String nickname;

    @Column(name = "birth_date", length = 10, nullable = false)
    private String birthDate;

    @Column(name = "marketing_consent", nullable = false)
    private boolean marketingConsent = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private MemberRole role = MemberRole.MEMBER;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "activity_status", nullable = false)
    private String activityStatus;

    @Builder
    public Member(
            String memberId, String password, String memberName, String phoneNumber,
            String email, String nickname, String birthDate, boolean marketingConsent,
            MemberRole role, LocalDateTime createdAt, LocalDateTime modifiedAt, String activityStatus
    ) {
        this.memberId = memberId;
        this.password = password;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nickname = nickname;
        this.birthDate = birthDate;
        this.marketingConsent = marketingConsent;
        this.role = role;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.activityStatus = activityStatus;
    }

}