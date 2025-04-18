package com.jamjam.bookjeok.domains.community.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "posts")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "writer_uid")
    private Long writerUid;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "is_valid")
    private boolean isValid = false;

    @Column(name = "created_At")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @Builder
    public Post (
            Long writerUid, String title, String content, boolean isValid,
            LocalDateTime createdAt, LocalDateTime modifiedAt, boolean isDeleted
    ) {
        this.writerUid = writerUid;
        this.title = title;
        this.content = content;
        this.isValid = isValid;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.isDeleted = isDeleted;
    }

    public void updatePost(String title, String content, LocalDateTime modifiedAt) {
        this.title = title;
        this.content = content;
        this.modifiedAt = modifiedAt;
    }

    public void deletePost(LocalDateTime modifiedAt, boolean isDeleted) {
        this.modifiedAt = modifiedAt;
        this.isDeleted = true;
    }
}