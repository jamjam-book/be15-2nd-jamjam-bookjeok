package com.jamjam.bookjeok.domains.community.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PostResponse {
    private Long postId;
    private String title;
    private String content;
    private Long writerUid;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}