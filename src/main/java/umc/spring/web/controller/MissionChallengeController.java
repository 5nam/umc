package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MemberCompleteMissionConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MemberReviewConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.ChallengeService.MissionChallengeService;
import umc.spring.service.MemberMissionService.MemberMissionQueryService;
import umc.spring.service.MemberMissionService.MemberMissionQueryServiceImpl;
import umc.spring.service.MissionService.MissionCreateService;
import umc.spring.web.dto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/challenges")
public class MissionChallengeController {

    private final MissionChallengeService missionChallengeService;
    private final MemberMissionQueryService missionQueryService;

    @PostMapping("/challenge")
    public ResponseDto<MissionChallengeResponseDTO.ChallengeDto> challenge(@RequestBody @Valid MissionChallengeRequestDTO.ChallengeDto request) {
        MemberMission challenge = missionChallengeService.challenge(request);
        return ResponseDto.onSuccess(MemberMissionConverter.toChallengeResultDTO(challenge));
    }

    @GetMapping("/{memberId}")
    @Operation(summary = "멤버별 미션 완료 목록 조회 API", description = "특정 멤버의 미션 완료 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseDto<MemberMissionCompleteDTO.completeMissionListDto> getMemberCompleteMission(@PathVariable(name="memberId") Long memberId, @RequestParam(name = "page") Integer page) {
        MemberMissionCompleteDTO.completeMissionListDto completeMission = MemberCompleteMissionConverter.missionListDTO(missionQueryService.getCompleteMissionList(memberId, page));
        return ResponseDto.onSuccess(completeMission);
    }
}
