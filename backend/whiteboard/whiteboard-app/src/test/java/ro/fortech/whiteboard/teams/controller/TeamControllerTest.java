/* package ro.fortech.whiteboard.teams.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ro.fortech.whiteboard.domain.teams.dto.TeamRequestDto;
import ro.fortech.whiteboard.domain.teams.dto.TeamResponseDto;
import ro.fortech.whiteboard.domain.teams.rest.controller.TeamControllerImpl;
import ro.fortech.whiteboard.domain.teams.service.TeamServiceImpl;
import ro.fortech.whiteboard.teams.dataProvider.TeamDataProvider;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamControllerImpl.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = {TeamControllerImpl.class, TeamServiceImpl.class})
class TeamControllerTest {

  private static final String TEAM_URL = "/teams";
  @Autowired
  private final ObjectMapper mapper = new ObjectMapper();
  private TeamRequestDto teamRequestDto;
  private TeamResponseDto teamResponseDto;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TeamServiceImpl teamService;

  @BeforeEach
  void setUp() {
    teamRequestDto = TeamDataProvider.getTeamRequestDtoMock();
    teamResponseDto = TeamDataProvider.getTeamResponseDtoMock();
  }

  @Test
  void testCreateTeam() throws Exception {
    when(teamService.createTeam(Mockito.any(TeamRequestDto.class))).thenReturn(teamResponseDto);
    String requestJson = mapper.writeValueAsString(teamRequestDto);
    mockMvc.perform(post(TEAM_URL + "/create")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(teamRequestDto.getId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(teamRequestDto.getName()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.numberOfUsers")
                .value(teamRequestDto.getNumberOfUsers()))
        .andReturn();

    verify(teamService, times(1)).createTeam(Mockito.any(TeamRequestDto.class));
  }

  @Test
  void testGetTeamById() throws Exception {
    when(teamService.getTeamById(Mockito.anyString())).thenReturn(teamResponseDto);

    mockMvc.perform(get(TEAM_URL + "/find/" + teamRequestDto.getId()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.id").value(teamResponseDto.getId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(teamRequestDto.getName()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.numberOfUsers")
                .value(teamRequestDto.getNumberOfUsers()));

    verify(teamService, times(1)).getTeamById(anyString());
  }

  @Test
  void testDeleteTeam() throws Exception {
    mockMvc.perform(delete(TEAM_URL + "/delete/" + teamRequestDto.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

    verify(teamService, times(1)).deleteTeamById(teamRequestDto.getId());
  }

  @Test
  void testUpdateTeam() throws Exception {
    String request = mapper.writeValueAsString(teamRequestDto);
    mockMvc.perform(put(TEAM_URL + "/update/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(request))
        .andExpect(status().isOk());

    verify(teamService, times(1)).updateTeamById(teamRequestDto);
  }
} */
