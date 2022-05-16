/* package ro.fortech.whiteboard.domain.boards.rest.controller;

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
import ro.fortech.whiteboard.domain.boards.BoardFactory;
import ro.fortech.whiteboard.domain.boards.dto.BoardRequestDto;
import ro.fortech.whiteboard.domain.boards.dto.BoardResponseDto;
import ro.fortech.whiteboard.domain.boards.rest.BoardControllerImpl;
import ro.fortech.whiteboard.domain.boards.service.BoardServiceImpl;
import ro.fortech.whiteboard.domain.boards.service.model.Board;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;
import ro.fortech.whiteboard.teams.dataProvider.TeamDataProvider;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoardControllerImpl.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = {BoardControllerImpl.class, BoardServiceImpl.class})
class BoardControllerImplTest {
    private static final String BOARDS_URL = "/board/";

    private Board board;
    private BoardRequestDto boardRequestDto;
    private BoardResponseDto boardResponseDto;
    private TeamEntity team;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardServiceImpl boardServiceImpl;

    @BeforeEach
    void setUp() {
        board = BoardFactory.getBoard();
        boardRequestDto = BoardFactory.getBoardRequestDto();
        boardResponseDto = BoardFactory.getBoardResponseDto();
        team = TeamDataProvider.getTeamEntityMock();
    }

    @Test
    void testCreateBoard() throws Exception {
        when(boardServiceImpl.createBoard(boardRequestDto)).thenReturn(boardResponseDto);

        mockMvc.perform(post(BOARDS_URL + "/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(boardResponseDto))
                )

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("BoardResponse1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createDateTime").value("2000-11-13 19:30:40.000"));

        verify(boardServiceImpl, times(1)).createBoard(Mockito.any(BoardRequestDto.class));
    }

    @Test
    void testGetBoardById() throws Exception {
        when(boardServiceImpl.getBoardById(boardRequestDto.getId())).thenReturn(boardResponseDto);

        mockMvc.perform(get(BOARDS_URL + "/find/" + boardRequestDto.getId()))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("BoardResponse1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createDateTime").value("2000-11-13 19:30:40.000"));

        verify(boardServiceImpl, times(1)).getBoardById(boardRequestDto.getId());
    }

    @Test
    void testUpdateBoardById() throws Exception {
        doNothing().when(boardServiceImpl).updateBoardById(boardRequestDto);

        mockMvc.perform(put(BOARDS_URL + "/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(boardResponseDto))
                )
                .andExpect(status().isOk());

        verify(boardServiceImpl, times(1)).updateBoardById(boardRequestDto);
    }

    @Test
    void testDeleteBoard() throws Exception {
        doNothing().when(boardServiceImpl).deleteBoard(board.getId());

        mockMvc.perform(delete(BOARDS_URL + "/delete/" + board.getId()))

                .andExpect(status().isOk());

        verify(boardServiceImpl, times(1)).deleteBoard(board.getId());
    }

    @Test
    void testGetBoardsByTeamId() throws Exception {
        when(boardServiceImpl.getBoardsByTeamId(team.getId())).thenReturn(List.of(boardResponseDto));

        mockMvc.perform(get(BOARDS_URL + "/find-boards/" + team.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))

            .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("BoardResponse1"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].createDateTime").value("2000-11-13 19:30:40.000"));

        verify(boardServiceImpl, times(1)).getBoardsByTeamId(team.getId());
    }
}
 */