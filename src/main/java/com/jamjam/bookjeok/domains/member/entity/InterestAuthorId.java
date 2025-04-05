package com.jamjam.bookjeok.domains.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class InterestAuthorId implements Serializable {

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "member_uid")
    private Long memberUid;

}