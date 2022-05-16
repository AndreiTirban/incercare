package ro.fortech.whiteboard.domain.teams.service.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.fortech.whiteboard.domain.teams.dto.TeamRequestDto;
import ro.fortech.whiteboard.domain.teams.dto.TeamResponseDto;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeamConverter {

  private final ModelMapper modelMapper;

  public TeamResponseDto entityToResponseDto(TeamEntity teamEntity) {
        return modelMapper.map(teamEntity, TeamResponseDto.class);
  }

  public TeamEntity requestDtoToEntity(TeamRequestDto teamRequestDto) {
    return modelMapper.map(teamRequestDto, TeamEntity.class);
  }
}
