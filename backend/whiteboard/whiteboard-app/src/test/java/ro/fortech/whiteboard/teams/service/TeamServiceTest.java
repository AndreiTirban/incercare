package ro.fortech.whiteboard.teams.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.fortech.whiteboard.domain.teams.dto.TeamRequestDto;
import ro.fortech.whiteboard.domain.teams.dto.TeamResponseDto;
import ro.fortech.whiteboard.domain.teams.repository.TeamRepository;
import ro.fortech.whiteboard.domain.teams.rest.exception.TeamNotDeleted;
import ro.fortech.whiteboard.domain.teams.rest.exception.TeamNotFound;
import ro.fortech.whiteboard.domain.teams.rest.exception.TeamNotUpdated;
import ro.fortech.whiteboard.domain.teams.service.TeamServiceImpl;
import ro.fortech.whiteboard.domain.teams.service.converter.TeamConverter;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static ro.fortech.whiteboard.teams.dataProvider.TeamDataProvider.*;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

  private TeamRequestDto teamRequestDto;
  private TeamResponseDto teamResponseDto;
  private TeamEntity teamEntity;

  @InjectMocks
  private TeamServiceImpl teamService;
  @Mock
  private TeamRepository teamRepository;
  @Mock
  private TeamConverter teamConverter;

  @BeforeEach
  void setUp() {
    teamRequestDto = getTeamRequestDtoMock();
    teamResponseDto = getTeamResponseDtoMock();
    teamEntity = getTeamEntityMock();
  }

  @Test
  void testTeamIsCreated() {
    when(teamConverter.requestDtoToEntity(teamRequestDto)).thenReturn(teamEntity);
    when(teamRepository.save(teamEntity)).thenReturn(teamEntity);
    when(teamConverter.entityToResponseDto(teamEntity)).thenReturn(teamResponseDto);

    TeamResponseDto equals = teamService.createTeam(teamRequestDto);

    assertThat(equals).isNotNull();
    assertEquals(teamRequestDto.getId(), equals.getId());
    assertEquals(teamRequestDto.getName(), equals.getName());
    assertEquals(teamRequestDto.getNumberOfUsers(), equals.getNumberOfUsers());

    verify(teamRepository).save(teamEntity);
  }

  @Test
  void testGetTeamByIdWhenEntityIsGiven() {
    when(teamRepository.findById(teamRequestDto.getId())).thenReturn(Optional.of(teamEntity));
    when(teamConverter.entityToResponseDto(teamEntity)).thenReturn(teamResponseDto);

    TeamResponseDto teamById = teamService.getTeamById(teamRequestDto.getId());

    assertThat(teamById).isNotNull();
    assertEquals(teamRequestDto.getId(), teamById.getId());
    assertEquals(teamRequestDto.getName(), teamById.getName());
    assertEquals(teamRequestDto.getNumberOfUsers(), teamById.getNumberOfUsers());
  }

  @Test
  void testTeamIsDeleted() {
    when(teamRepository.existsById(teamRequestDto.getId())).thenReturn(true);
    teamService.deleteTeamById(teamRequestDto.getId());

    verify(teamRepository).deleteById(teamRequestDto.getId());
  }

  @Test
  void testTeamIsUpdated() {
    when(teamRepository.existsById(teamRequestDto.getId())).thenReturn(true);
    when(teamConverter.requestDtoToEntity(any(TeamRequestDto.class))).thenReturn(teamEntity);
    teamService.updateTeamById(teamRequestDto);

    verify(teamRepository).save(teamEntity);
  }

  @Test
  void should_throwException_when_teamIsNotFound() {
    Exception exception = assertThrows(TeamNotFound.class,
        () -> teamService.getTeamById(getTeamRequestDtoMock().getId()));
    String message = exception.getMessage();
    String expectedNotFound = String
        .format("Team with id: %s could not be found.", teamRequestDto.getId());
    assertEquals(message, expectedNotFound);
  }

  @Test
  void should_throwException_when_teamIsNotDeleted() {
    Exception exception = assertThrows(TeamNotDeleted.class,
        () -> teamService.deleteTeamById(getTeamRequestDtoMock().getId()));
    String message = exception.getMessage();
    String expectedNotDeleted = String
        .format("Team with id: %s could not be deleted.", teamRequestDto.getId());
    assertEquals(message, expectedNotDeleted);
  }

  @Test
  void should_throwException_when_teamIsNotUpdated() {
    teamRequestDto = getTeamRequestDtoMock();
    Exception exception = assertThrows(TeamNotUpdated.class,
        () -> teamService.updateTeamById(teamRequestDto));
    String message = exception.getMessage();
    String expectedNotUpdated = String
        .format("Team with id: %s could not be updated.", teamRequestDto.getId());
    assertEquals(message, expectedNotUpdated);
  }
}
