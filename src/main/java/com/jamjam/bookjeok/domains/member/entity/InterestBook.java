package com.jamjam.bookjeok.domains.member.entity;

import com.jamjam.bookjeok.domains.book.entity.Book;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "interest_books")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterestBook {

    @Id @EmbeddedId
    private InterestBookId id;

    @MapsId("bookId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @MapsId("memberUid")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_uid")
    private Member member;

}