package com.jamjam.bookjeok.domains.community.controller;

import com.jamjam.bookjeok.common.dto.ApiResponse;
import com.jamjam.bookjeok.domains.community.dto.PostDTO;
import com.jamjam.bookjeok.domains.community.dto.PostListDTO;
import com.jamjam.bookjeok.domains.community.dto.PostRequest;
import com.jamjam.bookjeok.domains.community.dto.PostResponse;
import com.jamjam.bookjeok.domains.community.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;
    private PostRequest postRequest;
    private PostResponse postResponse;

    // 게시글 목록 조회
    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<PostListDTO>>> getAllPosts() {
        List<PostListDTO> posts = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(posts));
    }

    // 게시글 상세 조회
    @GetMapping("/detail/{postId}")
    public ResponseEntity<ApiResponse<PostDTO>> getPostByPostId(@PathVariable Long postId) {

        Map<String, Object> params = new HashMap<>();
        params.put("postId", postId);

        PostDTO post = postService.getPostByPostId(params);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(post));

    }

    // 게시글 등록
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<PostResponse>> createPost(
            @RequestBody PostRequest postRequest) {

        PostResponse response = postService.createPost(postRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }

    // 게시글 수정
    @PutMapping("/update/{postId}")
    public ResponseEntity<ApiResponse<PostResponse>> updatePost(
           @PathVariable Long postId,
           @RequestBody PostRequest postRequest) {

       PostResponse response = postService.updatePost(postId, postRequest);

       return ResponseEntity
               .status(HttpStatus.OK)
               .body(ApiResponse.success(response));
  }

    // 게시글 삭제
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<ApiResponse<PostResponse>> deletePost (
            @PathVariable Long postId) {

        postService.deletePost(postId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(null));
    }
}