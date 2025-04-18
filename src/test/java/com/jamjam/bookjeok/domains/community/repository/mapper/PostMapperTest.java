package com.jamjam.bookjeok.domains.community.repository.mapper;

import com.jamjam.bookjeok.domains.community.dto.PostDTO;
import com.jamjam.bookjeok.domains.community.dto.PostListDTO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@Transactional
@SpringBootTest
@ActiveProfiles("test")
class PostMapperTest {

    @Autowired
    PostMapper mapper;
    @Autowired
    PostMapper postMapper;

    @DisplayName("게시글 목록 조회 테스트")
    @Test
    void testFindAllPosts() {
        List<PostListDTO> posts = mapper.findAll();

        assertThat(posts).isNotNull();

        posts.forEach(System.out::println);
    }

    @DisplayName("특정 게시글 조회 테스트")
    @Test
    void testFindByPostId() {
        Map<String, Object > params = new HashMap<>();
        params.put("option", "postId");
        Long postId = 1L;
        params.put("postId", postId);

        PostDTO post = postMapper.findByPostId(params);

        assertThat(post).isNotNull();

        System.out.println(post);
    }
}