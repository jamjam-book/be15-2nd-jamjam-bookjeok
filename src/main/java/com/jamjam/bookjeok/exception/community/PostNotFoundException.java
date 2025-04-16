package com.jamjam.bookjeok.exception.community;

import lombok.Getter;

@Getter
public class PostNotFoundException extends RuntimeException {

    private final String message;

    public PostNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}