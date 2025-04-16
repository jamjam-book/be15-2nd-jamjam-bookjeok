package com.jamjam.bookjeok.domains.community.service;

import com.jamjam.bookjeok.domains.community.dto.PostDTO;
import com.jamjam.bookjeok.domains.community.dto.PostListDTO;
import com.jamjam.bookjeok.domains.community.dto.PostRequest;
import com.jamjam.bookjeok.domains.community.dto.PostResponse;
import com.jamjam.bookjeok.domains.community.entity.Post;
import com.jamjam.bookjeok.domains.community.repository.PostRepository;
import com.jamjam.bookjeok.domains.community.repository.mapper.PostMapper;

import com.jamjam.bookjeok.exception.community.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Setter
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private PostRequest postRequest;


    // 게시글 목록 조회
    public List<PostListDTO> getAllPosts() {

        return postMapper.findAll();

    }

    // 게시글 상세 조회
    public PostDTO getPostByPostId(Map<String, Object> params) {

        return postMapper.findByPostId(params);

    }

    // 게시글 등록
    public PostResponse createPost(PostRequest request) {

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .writerUid(request.getWriter_uid())
                .build();

        Post newPost = postRepository.save(post);
        return buildPostResponse(newPost);

    }

    private PostResponse buildPostResponse(Post post) {

        return PostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .writerUid(post.getWriterUid())
                .createdAt(post.getCreatedAt())
                .build();

    }

    // 게시글 삭제
    public void deletePost(Long postId) {

        Optional<Post> findPost = postRepository.findByPostId(postId);

        if (!findPost.isPresent()) {

            throw new PostNotFoundException("해당 게시글을 찾을 수 없음.");

        }

        postRepository.deleteById(postId);

    }

    public PostResponse updatePost(Long postId, PostRequest postRequest) {

        Optional<Post> findPost = postRepository.findByPostId(postId);

        if (!findPost.isPresent()) {
            throw new PostNotFoundException("해당 게시글을 찾을 수 없음.");
        }

        Post existingPost = findPost.get();

        Post updatedPost = existingPost.toBuilder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .modifiedAt(LocalDateTime.now())
                .build();

        postRepository.save(updatedPost);

        return new PostResponse(
                existingPost.getPostId(),
                existingPost.getTitle(),
                existingPost.getContent(),
                existingPost.getWriterUid(),
                existingPost.getCreatedAt(),
                existingPost.getModifiedAt()
        );
    }
}