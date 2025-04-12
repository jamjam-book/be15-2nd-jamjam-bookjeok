package com.jamjam.bookjeok.domains.member.repository.mapper;

import com.jamjam.bookjeok.domains.member.dto.request.PageRequest;
import com.jamjam.bookjeok.domains.member.dto.request.MemberSearchRequest;
import com.jamjam.bookjeok.domains.member.dto.MemberDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class AdminMapperTest {

    @Autowired
    private AdminMapper adminMapper;

    private PageRequest pageRequest;

    @DisplayName("findAllMember 테스트")
    @Test
    void findAllMemberTest(){
        pageRequest = new PageRequest();

        List<MemberDTO> members = adminMapper.findAllMember(pageRequest);

        assertNotNull(members);
        members.forEach(System.out::println);
    }

    @DisplayName("전체 멤버 인원 조회 테스트")
    @Test
    void countAllMember(){
        long count = adminMapper.countMembers();
        assertEquals(7, count);
    }
}