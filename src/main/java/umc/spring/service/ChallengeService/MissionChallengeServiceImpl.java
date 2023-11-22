package umc.spring.service.ChallengeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.handler.MemberHandler;
import umc.spring.base.exception.handler.MissionHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionChallengeRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionChallengeServiceImpl implements MissionChallengeService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission challenge(MissionChallengeRequestDTO.ChallengeDto request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(Code.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(Code.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toChallenge(member, mission);

        return memberMissionRepository.save(memberMission);
    }
}
