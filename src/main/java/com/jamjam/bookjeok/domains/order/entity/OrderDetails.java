package com.jamjam.bookjeok.domains.order.entity;

import com.jamjam.bookjeok.domains.book.entity.Book;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "order_details")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_uid", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "is_canceled", nullable = false)
    private boolean isCanceled = false;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime cratedAt;

    @Builder
    public OrderDetails(
            Order order, Book book, int price, int quantity,
            boolean isCanceled, LocalDateTime cratedAt
    ) {
        this.order = order;
        this.book = book;
        this.price = price;
        this.quantity = quantity;
        this.isCanceled = isCanceled;
        this.cratedAt = cratedAt;
    }

}