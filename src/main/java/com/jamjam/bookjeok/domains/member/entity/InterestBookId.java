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
public class InterestBookId implements Serializable {

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "member_uid")
    private Long memberUid;

}