package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionCreateRequestDTO;
import umc.spring.web.dto.MissionCreateResponseDTO;
import umc.spring.web.dto.ReviewEnrollRequestDTO;
import umc.spring.web.dto.ReviewEnrollResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionCreateResponseDTO.CreateResultDto toCreateResultDTO(Mission mission) {
        return MissionCreateResponseDTO.CreateResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionCreateRequestDTO.missionDto request, Store store) {

        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .store(store)
                .build();
    }
}
