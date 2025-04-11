package com.jamjam.bookjeok.domains.member.service;

import com.jamjam.bookjeok.domains.book.entity.Author;
import com.jamjam.bookjeok.domains.book.repository.AuthorRepository;
import com.jamjam.bookjeok.domains.member.dto.InterestAuthorDTO;
import com.jamjam.bookjeok.domains.member.dto.request.InterestAuthorRequest;
import com.jamjam.bookjeok.domains.member.entity.InterestAuthor;
import com.jamjam.bookjeok.domains.member.entity.InterestAuthorId;
import com.jamjam.bookjeok.domains.member.repository.mapper.InterestAuthorMapper;
import com.jamjam.bookjeok.domains.member.repository.repository.InterestAuthorRepository;
import com.jamjam.bookjeok.exception.member.interestAuthorException.AlreadyInterestedAuthorException;
import com.jamjam.bookjeok.exception.member.interestAuthorException.AuthorNotFoundException;
import com.jamjam.bookjeok.exception.member.MemberErrorCode;
import com.jamjam.bookjeok.exception.member.interestAuthorException.InterestAuthorLimitExceededException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestAuthorService {

    private final InterestAuthorMapper interestAuthorMapper;
    private final InterestAuthorRepository interestAuthorRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<InterestAuthorDTO> getInterestAuthorList(
            String memberId
    ){
        return interestAuthorMapper.findInterestAuthorByMemberId(memberId);
    }

    @Transactional
    public String createInterestAuthor(InterestAuthorRequest interestAuthorRequest){

        int totalInterestAuthor = interestAuthorMapper
                .countInterestAuthor(interestAuthorRequest.getMemberUid());

        // 작가의 인원이 30명이라면 추가할 수 없음
        if(totalInterestAuthor == 30){
            throw new InterestAuthorLimitExceededException(MemberErrorCode.INTEREST_AUTHOR_LIMIT_EXCEEDED);
        }

        // 작가 가져오기 (작가의 아이디를 가져오기 위해서 가져오는 것)
        Author author = authorRepository.findByAuthorName(interestAuthorRequest.getAuthorName())
                .orElseThrow(() -> new AuthorNotFoundException(MemberErrorCode.NOT_FOUND_AUTHOR));

        // 작가의 아이디와 멤버 uid 전달하기
        InterestAuthorId newInterestAuthorId =
                new InterestAuthorId(author.getAuthorId(), interestAuthorRequest.getMemberUid());

        // 이미 관심 작가가 등록되어 있는 경우 예외 처리하기
        if(interestAuthorRepository.existsById(newInterestAuthorId)){
            throw new AlreadyInterestedAuthorException(MemberErrorCode.ALREADY_INTERESTED_AUTHOR);
        }

        InterestAuthor newInterestAuthor = InterestAuthor.builder()
                .interestAuthorId(newInterestAuthorId)
                .build();

        interestAuthorRepository.save(newInterestAuthor);

        return interestAuthorRequest.getAuthorName();
    }

    @Transactional
    public void deleteInterestAuthor(InterestAuthorRequest interestAuthorRequest) {
        Author author = authorRepository.findByAuthorName(interestAuthorRequest.getAuthorName())
                .orElseThrow(() -> new AuthorNotFoundException(MemberErrorCode.NOT_FOUND_AUTHOR));

        InterestAuthorId interestAuthorId =
                new InterestAuthorId(author.getAuthorId(), interestAuthorRequest.getMemberUid());

        InterestAuthor interestAuthor = interestAuthorRepository.findById(interestAuthorId)
                .orElseThrow(() -> new AuthorNotFoundException(MemberErrorCode.NOT_REGIST_AUTHOR));

        interestAuthorRepository.delete(interestAuthor);
    }


}
