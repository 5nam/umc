package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewEnrollServiceImpl;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.ReviewEnrollRequestDTO;
import umc.spring.web.dto.ReviewEnrollResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewEnrollController {

    private final ReviewEnrollServiceImpl reviewEnrollService;

    @PostMapping("/enroll")
    public ResponseDto<ReviewEnrollResponseDTO.EnrollResultDto> join(@RequestBody @Valid ReviewEnrollRequestDTO.reviewDto request) {
        Review review = reviewEnrollService.enrollReview(request);
        return ResponseDto.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
