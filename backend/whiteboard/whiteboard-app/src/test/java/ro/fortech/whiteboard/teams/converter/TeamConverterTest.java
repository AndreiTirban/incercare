package ro.fortech.whiteboard.teams.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import ro.fortech.whiteboard.domain.teams.dto.TeamRequestDto;
import ro.fortech.whiteboard.domain.teams.dto.TeamResponseDto;
import ro.fortech.whiteboard.domain.teams.service.converter.TeamConverter;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;
import ro.fortech.whiteboard.teams.dataProvider.TeamDataProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TeamConverterTest {

  TeamEntity teamEntity;
  TeamRequestDto teamRequestDto;
  TeamResponseDto teamResponseDto;
  @InjectMocks
  private TeamConverter teamConverter;
  @Mock
  private ModelMapper modelMapper;

  @BeforeEach
  void setUp() {
    teamEntity = TeamDataProvider.getTeamEntityMock();
    teamRequestDto = TeamDataProvider.getTeamRequestDtoMock();
    teamResponseDto = TeamDataProvider.getTeamResponseDtoMock();
  }

  @Test
  public void testTeamEntityConvertsToResponseDto() {
    when(modelMapper.map(teamEntity, TeamResponseDto.class)).thenReturn(teamResponseDto);
    TeamResponseDto converted = teamConverter.entityToResponseDto(teamEntity);
    assertEquals(teamResponseDto.getId(), converted.getId());
    assertEquals(teamResponseDto.getName(), converted.getName());
  }

  @Test
  public void testTeamDtoConvertsToTeamEntity() {
    when(modelMapper.map(teamRequestDto, TeamEntity.class)).thenReturn(teamEntity);
    TeamEntity converted = teamConverter.requestDtoToEntity(teamRequestDto);
    assertEquals(teamRequestDto.getId(), converted.getId());
    assertEquals(teamRequestDto.getName(), converted.getName());

  }
}
