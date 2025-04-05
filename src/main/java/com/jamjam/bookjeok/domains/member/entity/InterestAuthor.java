package com.jamjam.bookjeok.domains.member.entity;

import com.jamjam.bookjeok.domains.book.entity.Book;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "interest_authors")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterestAuthor {

    @Id @EmbeddedId
    private InterestAuthorId id;

    @MapsId("authorId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Book book;

    @MapsId("memberUid")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_uid")
    private Member member;

}