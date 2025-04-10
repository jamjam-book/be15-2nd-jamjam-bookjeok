package com.jamjam.bookjeok.domains.member.service;

import com.jamjam.bookjeok.domains.member.dto.FollowDTO;
import com.jamjam.bookjeok.domains.member.dto.PostSummaryDTO;
import com.jamjam.bookjeok.domains.member.repository.mapper.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowMapper followMapper;

    @Transactional(readOnly = true)
    public List<FollowDTO> getFollowingListByMemberId(String memberId) {
        return followMapper.findFollowingListByMemberId(memberId);
    }

    @Transactional(readOnly = true)
    public List<PostSummaryDTO> getPostListByWriterId(String writerId) {
        return followMapper.findPostListByMemberId(writerId);
    }
}