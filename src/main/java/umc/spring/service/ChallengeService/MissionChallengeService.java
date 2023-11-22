package umc.spring.service.ChallengeService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionChallengeRequestDTO;

public interface MissionChallengeService {
    MemberMission challenge(MissionChallengeRequestDTO.ChallengeDto request);
}
