package umc.spring.web.dto;

import lombok.Getter;

public class ReviewEnrollRequestDTO {
    @Getter
    public static class reviewDto {
        String title;
        Float score;
        Long memberId;
    }
}
