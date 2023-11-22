package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionCreateService;
import umc.spring.web.dto.MissionCreateRequestDTO;
import umc.spring.web.dto.MissionCreateResponseDTO;
import umc.spring.web.dto.ReviewEnrollResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionCreateController {

    private final MissionCreateService missionCreateService;

    @PostMapping("/create")
    public ResponseDto<MissionCreateResponseDTO.CreateResultDto> create(@RequestBody @Valid MissionCreateRequestDTO.missionDto request) {
        Mission mission = missionCreateService.createMission(request);
        return ResponseDto.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }
}
