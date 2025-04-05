package com.jamjam.bookjeok.domains.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "member_blocks")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberBlock {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "block_start_date", nullable = false)
    private LocalDate blockStartDate;

    @Column(name = "block_end_date", nullable = false)
    private LocalDate blockEndDate;

    @Builder
    public MemberBlock(Member member, LocalDate blockStartDate, LocalDate blockEndDate) {
        this.member = member;
        this.blockStartDate = blockStartDate;
        this.blockEndDate = blockEndDate;
    }

}