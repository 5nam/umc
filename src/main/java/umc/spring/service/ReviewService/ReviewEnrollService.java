package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewEnrollRequestDTO;

public interface ReviewEnrollService {
    Review enrollReview(ReviewEnrollRequestDTO.reviewDto request);
}
