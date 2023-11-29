package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreRequestDTO {

    @Getter
    public static class ReviewDTO {
        String title;
        Float score;
        String body;
    }
}
