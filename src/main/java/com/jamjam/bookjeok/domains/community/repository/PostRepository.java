package com.jamjam.bookjeok.domains.community.repository;

import com.jamjam.bookjeok.domains.community.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByPostId(Long postId);

}