package com.jamjam.bookjeok.domains.question.entity;

import com.jamjam.bookjeok.domains.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "questions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_uid", referencedColumnName = "member_uid", nullable = false)
    private Member writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_categories_id", nullable = false)
    private QuestionCategory questionCategory;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "questions_img_url")
    private String questionsImgUrl;

    @Builder
    public Question(
            Member writer, QuestionCategory questionCategory,
            String title, String contents, LocalDateTime createdAt,
            LocalDateTime modifiedAt, boolean isDeleted, String questionsImgUrl
    ) {
        this.writer = writer;
        this.questionCategory = questionCategory;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.isDeleted = isDeleted;
        this.questionsImgUrl = questionsImgUrl;
    }

}