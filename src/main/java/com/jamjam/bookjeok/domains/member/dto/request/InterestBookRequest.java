package com.jamjam.bookjeok.domains.member.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class InterestBookRequest {

    @NotNull(message = "책의 이름은 비어있을 수 없습니다.")
    private final String bookName;

    @NotNull(message = "멤버 아이디는 비어있을 수 없습니다.")
    private final Long memberUid;

}
