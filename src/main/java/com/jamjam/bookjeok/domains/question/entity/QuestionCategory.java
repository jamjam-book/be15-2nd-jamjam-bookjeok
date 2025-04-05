package com.jamjam.bookjeok.domains.question.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "question_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_category_id")
    private Long id;

    @Column(name = "question_category_name", length = 100, nullable = false)
    private String questionCategoryName;

    @Builder
    public QuestionCategory(String questionCategoryName) {
        this.questionCategoryName = questionCategoryName;
    }

}