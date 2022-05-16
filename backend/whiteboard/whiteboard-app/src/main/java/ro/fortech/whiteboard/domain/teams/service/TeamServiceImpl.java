package ro.fortech.whiteboard.domain.teams.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.whiteboard.domain.teams.dto.TeamRequestDto;
import ro.fortech.whiteboard.domain.teams.dto.TeamResponseDto;
import ro.fortech.whiteboard.domain.teams.repository.TeamRepository;
import ro.fortech.whiteboard.domain.teams.rest.exception.TeamNotDeleted;
import ro.fortech.whiteboard.domain.teams.rest.exception.TeamNotFound;
import ro.fortech.whiteboard.domain.teams.rest.exception.TeamNotUpdated;
import ro.fortech.whiteboard.domain.teams.service.converter.TeamConverter;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeamServiceImpl implements TeamService {

  private final TeamRepository teamRepository;
  private final TeamConverter teamConverter;

  @Override
  public TeamResponseDto createTeam(@Valid TeamRequestDto teamRequestDto) {
    TeamEntity teamEntity = teamConverter.requestDtoToEntity(teamRequestDto);
    teamRepository.save(teamEntity);
    return teamConverter.entityToResponseDto(teamEntity);
  }

  @Override
  public TeamResponseDto getTeamById(String id) {
    TeamEntity teamEntity = teamRepository.findById(id)
        .orElseThrow(() -> {
          throw new TeamNotFound(returnNotFoundMessage(id));
        });
    return teamConverter.entityToResponseDto(teamEntity);
  }

  @Override
  public void deleteTeamById(String id) {
    try {
      if (teamRepository.existsById(id)) {
        teamRepository.deleteById(id);
      } else {
        throw new TeamNotFound(returnNotFoundMessage(id));
      }
    } catch (Exception e) {
      throw new TeamNotDeleted(returnNotDeletedMessage(id));
    }
  }

  @Override
  public void updateTeamById(TeamRequestDto teamRequestDto) {
    String teamId = teamRequestDto.getId();
    try {
      if (teamRepository.existsById(teamId)) {
        teamRepository.save(teamConverter.requestDtoToEntity(teamRequestDto));
      } else {
        throw new TeamNotFound(returnNotFoundMessage(teamId));
      }
    } catch (Exception e) {
      throw new TeamNotUpdated(returnNotUpdatedMessage(teamId));
    }
  }

  private String returnNotFoundMessage(String id) {
    return String.format("Team with id: %s could not be found.", id);
  }

  private String returnNotDeletedMessage(String id) {
    return String.format("Team with id: %s could not be deleted.", id);
  }

  private String returnNotUpdatedMessage(String id) {
    return String.format("Team with id: %s could not be updated.", id);
  }
}
