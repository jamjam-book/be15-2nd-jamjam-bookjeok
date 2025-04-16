package com.jamjam.bookjeok.domains.community.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostListDTO {

    private Long postId;
    private Long writerUid;
    private String title;
    private String nickname;

}