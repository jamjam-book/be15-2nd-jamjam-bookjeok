package com.jamjam.bookjeok.domains.community.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class PostRequest {

    private String title;
    private String content;
    private Long writer_uid;

}