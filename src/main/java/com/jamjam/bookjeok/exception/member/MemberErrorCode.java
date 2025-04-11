package com.jamjam.bookjeok.exception.member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum MemberErrorCode {
    NOT_FOLLOW("1000", "팔로우 하지 않는 사용자입니다.", HttpStatus.NOT_FOUND),
    NOT_EXIST_MEMBER("1001", "존재하지 않는 사용자입니다.", HttpStatus.NOT_FOUND),
    MEMBER_SEARCH_CONDITION_MISSING("1002", "memberId 또는 nickname 중 하나는 필수입니다", HttpStatus.BAD_REQUEST),
    NOT_FOUND_AUTHOR("1003", "존재하지 않는 작가입니다.", HttpStatus.NOT_FOUND),
    ALREADY_INTERESTED_AUTHOR("1004", "이미 즐겨찾기에 추가한 작가입니다.", HttpStatus.ALREADY_REPORTED),
    INTEREST_AUTHOR_LIMIT_EXCEEDED("1005","관심 작가는 최대 30명까지 등록할 수 있습니다.", HttpStatus.TOO_MANY_REQUESTS),
    NOT_REGIST_AUTHOR("1006", "관심 작가에 등록되어 있지 않습니다.", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}