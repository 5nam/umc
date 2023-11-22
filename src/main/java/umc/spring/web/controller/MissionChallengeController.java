package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.ChallengeService.MissionChallengeService;
import umc.spring.service.MissionService.MissionCreateService;
import umc.spring.web.dto.MissionChallengeRequestDTO;
import umc.spring.web.dto.MissionChallengeResponseDTO;
import umc.spring.web.dto.MissionCreateRequestDTO;
import umc.spring.web.dto.MissionCreateResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/challenges")
public class MissionChallengeController {

    private final MissionChallengeService missionChallengeService;

    @PostMapping("/challenge")
    public ResponseDto<MissionChallengeResponseDTO.ChallengeDto> challenge(@RequestBody @Valid MissionChallengeRequestDTO.ChallengeDto request) {
        MemberMission challenge = missionChallengeService.challenge(request);
        return ResponseDto.onSuccess(MemberMissionConverter.toChallengeResultDTO(challenge));
    }
}
