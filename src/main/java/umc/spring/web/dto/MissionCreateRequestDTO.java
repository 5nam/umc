package umc.spring.web.dto;

import lombok.Getter;

import java.time.LocalDate;

public class MissionCreateRequestDTO {
    @Getter
    public static class missionDto {
        Integer reward;
        LocalDate deadline;
        String missionSpec;
        Long store_id;
    }
}
