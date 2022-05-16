package ro.fortech.whiteboard.domain.teams.service;

import org.springframework.stereotype.Service;
import ro.fortech.whiteboard.domain.teams.dto.TeamRequestDto;
import ro.fortech.whiteboard.domain.teams.dto.TeamResponseDto;

import javax.validation.Valid;

@Service
public interface TeamService {

  TeamResponseDto createTeam(@Valid TeamRequestDto teamRequestDto);

  TeamResponseDto getTeamById(String id);

  void deleteTeamById(String id);

  void updateTeamById(@Valid TeamRequestDto teamRequestDto);
}
