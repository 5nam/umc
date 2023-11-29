package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MemberMissionCompleteDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberCompleteMissionConverter {

    public static MemberMissionCompleteDTO.completeMission missionPreViewDTO(Mission mission) {
        return MemberMissionCompleteDTO.completeMission.builder()
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .storeName(mission.getStore().getName())
                .build();
    }

    public static MemberMissionCompleteDTO.completeMissionListDto missionListDTO(Page<Mission> missionList) {
        List<MemberMissionCompleteDTO.completeMission> missionPreViewDTOList = missionList.stream()
                .map(MemberCompleteMissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberMissionCompleteDTO.completeMissionListDto.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
