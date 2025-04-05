package com.jamjam.bookjeok.domains.book.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "book_authors")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookAuthor {

    @Id @EmbeddedId
    private BookAuthorId id;

    @MapsId("bookId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @MapsId("authorId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Builder
    public BookAuthor(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

}