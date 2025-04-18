package com.jamjam.bookjeok.domains.community.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jamjam.bookjeok.domains.community.dto.PostRequest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("게시글 목록 조회 테스트")
    @Test
    void getPostListTest() throws Exception {
        mockMvc.perform(get("/api/v1/posts/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.length()").value(5))
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.data").isArray())
                .andDo(print());
    }

    @DisplayName("게시글 상세 내용 조회 테스트")
    @Test
    void getPostDetailByPostIdTest() throws Exception {
        mockMvc.perform(get("/api/v1/posts/detail/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.postId").value(1))
                .andExpect(jsonPath("$.data.writerUid").value(1))
                .andExpect(jsonPath("$.data.title").value("한강 작가님"))
                .andExpect(jsonPath("$.data.content").value("노벨 문학상 GOAT"))
                .andExpect(jsonPath("$.data.nickname").value("닉네임01"))
                .andDo(print());
    }

    @DisplayName("게시글 등록 테스트")
    @Test
    void testCreatePost() throws Exception {
        Long writerUid = 7L;

        PostRequest postRequest = PostRequest.builder()
                .title("백엔드 프로젝트")
                .content("모두 파이팅 !")
                .writer_uid(writerUid)
                .build();

        String json = objectMapper.writeValueAsString(postRequest);

        mockMvc.perform(post("/api/v1/posts/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.title").value("백엔드 프로젝트"))
                .andExpect(jsonPath("$.data.content").value("모두 파이팅 !"))
                .andExpect(jsonPath("$.data.writerUid").value(7))
                .andDo(print());

    }

    @DisplayName("게시글 수정 테스트")
    @Test
    void testModifyPostByPostId() throws Exception {

        Long postId = 1L;

        PostRequest postRequest = PostRequest.builder()
                .title("프런트엔드 프로젝트도")
                .content("파이팅 !")
                .build();

        String title = objectMapper.writeValueAsString(postRequest);
        String content = objectMapper.writeValueAsString(postRequest);

        mockMvc.perform(put("/api/v1/posts/update/{postId}", postId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.postId").value(postId))
                .andExpect(jsonPath("$.data.title").value("프런트엔드 프로젝트도"))
                .andExpect(jsonPath("$.data.content").value("파이팅 !"));
    }

    @DisplayName("게시글 삭제 테스트")
    @Test
    void testDeletePostByPostId() throws Exception {
        Long postId = 1L;

        mockMvc.perform(delete("/api/v1/posts/delete/{postId}", postId)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}