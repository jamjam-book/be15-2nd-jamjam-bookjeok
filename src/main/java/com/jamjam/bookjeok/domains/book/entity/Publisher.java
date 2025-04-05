package com.jamjam.bookjeok.domains.book.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "publishers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Publisher {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long id;

    @Column(name = "publisher_name", nullable = false)
    private String publisherName;

    @Builder
    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

}