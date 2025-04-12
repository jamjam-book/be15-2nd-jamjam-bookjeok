package com.jamjam.bookjeok.domains.member.service;

import com.jamjam.bookjeok.domains.member.dto.request.PageRequest;
import com.jamjam.bookjeok.domains.member.dto.request.MemberSearchRequest;
import com.jamjam.bookjeok.domains.member.dto.MemberDTO;
import com.jamjam.bookjeok.domains.member.dto.response.MemberDetailResponse;
import com.jamjam.bookjeok.domains.member.dto.response.MemberListResponse;
import com.jamjam.bookjeok.domains.member.entity.Member;
import com.jamjam.bookjeok.domains.member.entity.MemberRole;
import com.jamjam.bookjeok.domains.member.repository.mapper.AdminMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @Mock
    private AdminMapper adminMapper;

    @InjectMocks
    private AdminService adminService;

    @DisplayName("findAllMember 서비스 단위 테스트")
    @Test
    void getAllMemberTest() {
        // given
        PageRequest request = new PageRequest();

        MemberDTO member1 = new MemberDTO(
                1L,
                "user01",
                "홍길동",
                "01012345678",
                "test1@gmail.com",
                "닉네임01",
                "19970816",
                true,
                MemberRole.MEMBER,
                LocalDateTime.of(2025, 4, 6, 11, 13, 40),
                LocalDateTime.of(2025, 4, 7, 11, 30, 40),
                "ACTIVE"
        );

        MemberDTO member2 = new MemberDTO(
                2L,
                "user02",
                "유형진",
                "01024001349",
                "test2@gmail.com",
                "닉네임02",
                "19970918",
                true,
                MemberRole.MEMBER,
                LocalDateTime.of(2025, 2, 6, 14, 13, 32),
                null,
                "DEACTIVATE"
        );


        List<MemberDTO> fakeMembers = Arrays.asList(member1, member2);

        when(adminMapper.findAllMember(request)).thenReturn(fakeMembers);
        when(adminMapper.countMembers()).thenReturn(2L);

        long totalItems = adminMapper.countMembers();
        int page = request.getPage();
        int size = request.getSize();

        MemberListResponse response = adminService.getAllMembers(request);

        assertNotNull(response);
        assertEquals(2, response.getMemberList().size());
        response.getMemberList().forEach(System.out::println);
    }
}
