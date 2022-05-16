package ro.fortech.whiteboard.teams.dataProvider;

import lombok.experimental.UtilityClass;
import ro.fortech.whiteboard.domain.teams.dto.TeamRequestDto;
import ro.fortech.whiteboard.domain.teams.dto.TeamResponseDto;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;

@UtilityClass
public class TeamDataProvider {

  private final String TEAM_ID = "e46c9ac4-389c-11ec-8d3d-0242ac130003";
  private final String TEAM_NAME = "Test";
  private final int TEAM_NUMBER_OF_USERS = 1;

  public static TeamRequestDto getTeamRequestDtoMock() {
    TeamRequestDto teamRequestDto = new TeamRequestDto();
    teamRequestDto.setId(TEAM_ID);
    teamRequestDto.setName(TEAM_NAME);
    teamRequestDto.setNumberOfUsers(TEAM_NUMBER_OF_USERS);
    return teamRequestDto;
  }

  public static TeamEntity getTeamEntityMock() {
    TeamEntity teamEntity = new TeamEntity();
    teamEntity.setId(TEAM_ID);
    teamEntity.setName(TEAM_NAME);
    teamEntity.setNumberOfUsers(TEAM_NUMBER_OF_USERS);
    return teamEntity;
  }

  public static TeamResponseDto getTeamResponseDtoMock() {
    TeamResponseDto teamResponseDto = new TeamResponseDto();
    teamResponseDto.setId(TEAM_ID);
    teamResponseDto.setName(TEAM_NAME);
    teamResponseDto.setNumberOfUsers(TEAM_NUMBER_OF_USERS);
    return teamResponseDto;
  }
}
