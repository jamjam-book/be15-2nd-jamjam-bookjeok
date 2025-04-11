package com.jamjam.bookjeok.domains.member.repository.repository;

import com.jamjam.bookjeok.domains.member.entity.InterestAuthor;
import com.jamjam.bookjeok.domains.member.entity.InterestAuthorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestAuthorRepository extends JpaRepository<InterestAuthor, InterestAuthorId> {
}
