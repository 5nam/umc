package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionQueryService {
    Page<Mission> getCompleteMissionList(Long memberId, Integer page);
}
