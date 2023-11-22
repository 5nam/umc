package umc.spring.web.dto;

import lombok.Getter;

import java.time.LocalDate;

public class MissionChallengeRequestDTO {
    @Getter
    public static class ChallengeDto {
        Long missionId;
        Long memberId;
    }
}
