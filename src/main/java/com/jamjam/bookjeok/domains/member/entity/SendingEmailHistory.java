package com.jamjam.bookjeok.domains.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "sending_email_histories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SendingEmailHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sending_email_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_uid", nullable = false)
    private Member member;

    @Lob
    @Column(name = "email_content", nullable = false)
    private String emailContent;

    @Column(name = "sending_status_value", nullable = false)
    private Boolean sendingStatusValue;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    @Builder
    public SendingEmailHistory(
            Member member, String emailContent,
            Boolean sendingStatusValue, LocalDateTime sentAt
    ) {
        this.member = member;
        this.emailContent = emailContent;
        this.sendingStatusValue = sendingStatusValue;
        this.sentAt = sentAt;
    }

}