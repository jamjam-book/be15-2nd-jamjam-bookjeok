package com.jamjam.bookjeok.domains.member.service;

import com.jamjam.bookjeok.domains.member.dto.InterestAuthorDTO;
import com.jamjam.bookjeok.domains.member.dto.request.InterestAuthorRequest;
import com.jamjam.bookjeok.exception.member.interestAuthorException.AlreadyInterestedAuthorException;
import com.jamjam.bookjeok.exception.member.interestAuthorException.AuthorNotFoundException;
import com.jamjam.bookjeok.exception.member.interestAuthorException.InterestAuthorLimitExceededException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
public class InterestAuthorServiceTest {

    @Autowired
    private InterestAuthorService interestAuthorService;

    @DisplayName("회원의 책 즐겨찾기 목록 가져오기")
    @Test
    void findInterestAuthorByMemberIdTest(){
        String memberId = "user02";

        List<InterestAuthorDTO> interestAuthorList
                = interestAuthorService.getInterestAuthorList(memberId);

        assertNotNull(interestAuthorList);
    }

    @DisplayName("관심 작가 등록하기")
    @Test
    void createInterestAuthorTest(){
        Long memberUid = 2L;

        String authorName = "공지영";
        InterestAuthorRequest request = new InterestAuthorRequest(authorName, memberUid);
        String response = interestAuthorService.createInterestAuthor(request);

        assertEquals("공지영", response);
        assertThrows(AlreadyInterestedAuthorException.class, () -> {
            interestAuthorService.createInterestAuthor(request);
        });
    }

    @DisplayName("관심 작가 등록시 작가가 없는 경우 예외 테스트")
    @Test
    void createInterestAuthorExceptionTest1(){
        Long memberUid = 2L;

        String authorName = "정유진";
        InterestAuthorRequest request2 = new InterestAuthorRequest(authorName, memberUid);
        assertThrows(AuthorNotFoundException.class, () -> {
            interestAuthorService.createInterestAuthor(request2);
        });
    }

    @DisplayName("관심 작가 삭제하기")
    @Test
    void deleteInterestAuthorTest(){
        Long memberUid = 2L;
        String authorName = "한강";

        InterestAuthorRequest request = new InterestAuthorRequest(authorName, memberUid);
        interestAuthorService.deleteInterestAuthor(request);

        assertThrows(AuthorNotFoundException.class, () -> {
            interestAuthorService.deleteInterestAuthor(request);
        });
    }
}
