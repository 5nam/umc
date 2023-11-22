package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionChallengeRequestDTO;
import umc.spring.web.dto.MissionChallengeResponseDTO;
import umc.spring.web.dto.MissionCreateRequestDTO;
import umc.spring.web.dto.MissionCreateResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MissionChallengeResponseDTO.ChallengeDto toChallengeResultDTO(MemberMission memberMission) {
        return MissionChallengeResponseDTO.ChallengeDto
                .builder()
                .challengeId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toChallenge(Member member, Mission mission) {

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
