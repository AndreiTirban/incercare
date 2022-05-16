package ro.fortech.whiteboard.domain.teams.rest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.fortech.whiteboard.domain.teams.TeamController;
import ro.fortech.whiteboard.domain.teams.dto.TeamRequestDto;
import ro.fortech.whiteboard.domain.teams.dto.TeamResponseDto;
import ro.fortech.whiteboard.domain.teams.service.TeamServiceImpl;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Tag(name = "Team API", description = "<h4> Team API performing CRUD operations </h4>")
public class TeamControllerImpl implements TeamController {

  private final TeamServiceImpl teamService;

  @Override
  public TeamResponseDto getTeamById(String id) {
    return teamService.getTeamById(id);
  }

  @Override
  public TeamResponseDto addTeam(TeamRequestDto teamRequestDto) {
    return teamService.createTeam(teamRequestDto);
  }

  @Override
  public void updateTeamById(TeamRequestDto teamRequestDto) {
    teamService.updateTeamById(teamRequestDto);
  }

  @Override
  public void deleteTeamById(String id) {
    teamService.deleteTeamById(id);
  }
}
