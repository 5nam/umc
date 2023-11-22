package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionCreateRequestDTO;

public interface MissionCreateService {
    Mission createMission(MissionCreateRequestDTO.missionDto request);
}
