package com.jamjam.bookjeok.domains.member.controller;

import com.jamjam.bookjeok.common.dto.ApiResponse;
import com.jamjam.bookjeok.domains.member.dto.InterestAuthorDTO;
import com.jamjam.bookjeok.domains.member.dto.request.InterestAuthorRequest;
import com.jamjam.bookjeok.domains.member.dto.response.InterestAuthorResponse;
import com.jamjam.bookjeok.domains.member.service.InterestAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InterestAuthorController {

    private final InterestAuthorService interestAuthorService;

    @GetMapping("/{memberId}/interest-authors")
    public ResponseEntity<ApiResponse<List<InterestAuthorDTO>>> getInterestAuthorByMemberId(
            @PathVariable String memberId
    ){

        List<InterestAuthorDTO> interestAuthorList
                = interestAuthorService.getInterestAuthorList(memberId);

        return ResponseEntity.ok(ApiResponse.success(interestAuthorList));

    }

    @PostMapping("/interest-author")
    public ResponseEntity<ApiResponse<InterestAuthorResponse>> createInterestAuthor(
            @RequestBody @Validated InterestAuthorRequest request
    ){

        interestAuthorService.createInterestAuthor(request);

        InterestAuthorResponse response = InterestAuthorResponse.builder()
                .authorName(request.getAuthorName())
                .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }

    @DeleteMapping("/interest-author")
    public ResponseEntity<ApiResponse<Void>> deleteInterestAuthor(
            @RequestBody @Validated InterestAuthorRequest request
    ){
        interestAuthorService.deleteInterestAuthor(request);

        return ResponseEntity.ok(ApiResponse.success(null));
    }

}
