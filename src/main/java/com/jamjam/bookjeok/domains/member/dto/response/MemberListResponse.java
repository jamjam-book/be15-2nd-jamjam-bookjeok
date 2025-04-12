package com.jamjam.bookjeok.domains.member.dto.response;

import com.jamjam.bookjeok.common.dto.Pagination;
import com.jamjam.bookjeok.domains.member.dto.MemberDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MemberListResponse {

    private List<MemberDTO> memberList;
    private final Pagination pagination;

}
