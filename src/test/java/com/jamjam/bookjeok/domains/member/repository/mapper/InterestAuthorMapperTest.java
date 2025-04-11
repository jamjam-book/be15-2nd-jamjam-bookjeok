package com.jamjam.bookjeok.domains.member.repository.mapper;

import com.jamjam.bookjeok.domains.member.dto.InterestAuthorDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@SpringBootTest
class InterestAuthorMapperTest {

    @Autowired
    private InterestAuthorMapper interestAuthorMapper;

    @DisplayName("특정 회원이 즐겨찾기한 작가 목록 가져오기")
    @Test
    void findInterestBookListTest(){
        String memberId = "user01";

        List<InterestAuthorDTO> interestAuthorList = interestAuthorMapper.findInterestAuthorByMemberId(memberId);

        assertNotNull(interestAuthorList);
        interestAuthorList.forEach(System.out::println);

    }

    @DisplayName("회원의 관심 작가 수 가져오기")
    @Test
    void countInterestAuthorTest(){
        Long memberUid = 2L;

        int totalInterestAuthor = interestAuthorMapper.countInterestAuthor(memberUid);

        assertEquals(2, totalInterestAuthor);
    }

}