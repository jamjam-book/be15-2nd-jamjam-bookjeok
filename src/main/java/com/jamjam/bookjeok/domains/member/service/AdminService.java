package com.jamjam.bookjeok.domains.member.service;

import com.jamjam.bookjeok.common.dto.Pagination;
import com.jamjam.bookjeok.domains.member.dto.request.PageRequest;
import com.jamjam.bookjeok.domains.member.dto.request.MemberSearchRequest;
import com.jamjam.bookjeok.domains.member.dto.MemberDTO;
import com.jamjam.bookjeok.domains.member.dto.response.MemberDetailResponse;
import com.jamjam.bookjeok.domains.member.dto.response.MemberListResponse;
import com.jamjam.bookjeok.domains.member.repository.mapper.AdminMapper;
import com.jamjam.bookjeok.exception.member.MemberErrorCode;
import com.jamjam.bookjeok.exception.member.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminMapper adminMapper;

    // 멤버의 전체 목록을 조회하는 기능
    @Transactional(readOnly = true)
    public MemberListResponse getAllMembers(PageRequest pageRequest) {
        List<MemberDTO> members = adminMapper.findAllMember(pageRequest);

        // 페이징 처리를 위해 전체 멤버의 수 조회하기
        long totalItems = adminMapper.countMembers();

        int page = pageRequest.getPage();
        int size = pageRequest.getSize();

        return MemberListResponse.builder()
                .memberList(members)
                .pagination(Pagination.builder()
                    .currentPage(page)
                    .totalPage((int)Math.ceil((double)totalItems/size))
                    .totalItems(totalItems)
                    .build())
                .build();
    }
}
