package com.jamjam.bookjeok.domains.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jamjam.bookjeok.domains.member.dto.request.InterestAuthorRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class InterestAuthorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @DisplayName("멤버의 아이디로 즐겨찾기 한 작가 목록 가져오기")
    @Test
    void getInterestAuthorByMemberIdTest() throws Exception {
        String memberId = "user01";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/{memberId}/interest-authors", memberId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].authorName").value("조정래"))
                .andExpect(jsonPath("$.data[0].bookList[0].bookName").value("태백산맥 1권"))
                .andExpect(jsonPath("$.timestamp").exists())
                .andDo(print());
    }

    @DisplayName("관심 작가 등록하기")
    @Test
    void createInterestAuthorTest() throws Exception {
        InterestAuthorRequest request = new InterestAuthorRequest("공지영", 2L);

        mockMvc.perform(post("/api/v1/interest-author")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.authorName").value("공지영"))
                .andReturn();
    }

    @DisplayName("관심 작가 삭제하기")
    @Test
    void deleteInterestAuthorTest() throws Exception {
        InterestAuthorRequest request = new InterestAuthorRequest("정약용", 2L);

        mockMvc.perform(delete("/api/v1/interest-author")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(jsonPath("$.success").value(true));
    }

}
