package com.jamjam.bookjeok.domains.community.entity;

import com.jamjam.bookjeok.domains.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "reports")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporter_uid", referencedColumnName = "member_uid", nullable = false)
    private Member reporter;

    @Column(name = "report_reason")
    private String reportReason;

    @Column(name = "reported_at", nullable = false)
    private LocalDateTime reportedAt;

    @Builder
    public Report(
            Post post, Comment comment, Member reporter,
            String reportReason, LocalDateTime reportedAt
    ) {
        this.post = post;
        this.comment = comment;
        this.reporter = reporter;
        this.reportReason = reportReason;
        this.reportedAt = reportedAt;
    }

}