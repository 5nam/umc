package umc.spring.web.dto;

import lombok.Getter;

public class MemberReviewRequestDTO {
    @Getter
    public static class ReviewDTO {
        Long memberId;
    }
}
