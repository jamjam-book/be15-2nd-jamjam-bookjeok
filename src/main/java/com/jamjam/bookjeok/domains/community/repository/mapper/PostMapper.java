package com.jamjam.bookjeok.domains.community.repository.mapper;

import com.jamjam.bookjeok.domains.community.dto.PostDTO;
import com.jamjam.bookjeok.domains.community.dto.PostListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostMapper {

    List<PostListDTO> findAll(); // 게시글 목록 조회

    PostDTO findByPostId(Map <String, Object> params);
}