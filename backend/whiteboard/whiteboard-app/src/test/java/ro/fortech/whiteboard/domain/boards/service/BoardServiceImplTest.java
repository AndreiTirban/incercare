package ro.fortech.whiteboard.domain.boards.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.fortech.whiteboard.domain.boards.BoardFactory;
import ro.fortech.whiteboard.domain.boards.dto.BoardRequestDto;
import ro.fortech.whiteboard.domain.boards.dto.BoardResponseDto;
import ro.fortech.whiteboard.domain.boards.repository.BoardRepository;
import ro.fortech.whiteboard.domain.boards.rest.exception.BoardNotDeleted;
import ro.fortech.whiteboard.domain.boards.rest.exception.BoardNotFound;
import ro.fortech.whiteboard.domain.boards.rest.exception.BoardNotUpdated;
import ro.fortech.whiteboard.domain.boards.service.converter.BoardConverter;
import ro.fortech.whiteboard.domain.boards.service.model.Board;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;
import ro.fortech.whiteboard.teams.dataProvider.TeamDataProvider;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BoardServiceImplTest {

    private Board board;
    private BoardRequestDto boardRequestDto;
    private BoardResponseDto boardResponseDto;
    private TeamEntity team;

    @InjectMocks
    private BoardServiceImpl boardServiceImpl;

    @Mock
    private BoardRepository boardRepository;

    @Mock
    private BoardConverter boardConverter;

    @BeforeEach
    void setUp() {
        board = BoardFactory.getBoard();
        boardRequestDto = BoardFactory.getBoardRequestDto();
        boardResponseDto = BoardFactory.getBoardResponseDto();
        team = TeamDataProvider.getTeamEntityMock();
    }

    @Test
    void testCreateBoard() {
        when(boardConverter.fromRequestDtoToEntity(boardRequestDto)).thenReturn(board);
        when(boardRepository.save(board)).thenReturn(board);
        when(boardConverter.fromEntityToResponseDto(board)).thenReturn(boardResponseDto);

        BoardResponseDto result = boardServiceImpl.createBoard(boardRequestDto);

        assertEquals(result.getTitle(), boardResponseDto.getTitle());
        assertEquals(result.getCreateDateTime(), boardResponseDto.getCreateDateTime());
    }

    @Test
    void testGetBoardById() {
        when(boardRepository.findById(board.getId())).thenReturn(Optional.of(board));
        when(boardConverter.fromEntityToResponseDto(board)).thenReturn(boardResponseDto);

        BoardResponseDto result = boardServiceImpl.getBoardById(board.getId());

        assertEquals(result.getTitle(), boardResponseDto.getTitle());
        assertEquals(result.getCreateDateTime(), boardResponseDto.getCreateDateTime());

    }

    @Test
    void testUpdateBoardById() {
        when(boardRepository.existsById(boardRequestDto.getId())).thenReturn(true);
        when(boardConverter.fromRequestDtoToEntity(boardRequestDto)).thenReturn(board);
        when(boardRepository.save(board)).thenReturn(board);

        boardServiceImpl.updateBoardById(boardRequestDto);

        verify(boardRepository, times(1)).save(board);
    }

    @Test
    void testDeleteBoard() {
        when(boardRepository.existsById(board.getId())).thenReturn(true);
        doNothing().when(boardRepository).deleteById(board.getId());

        boardServiceImpl.deleteBoard(board.getId());

        verify(boardRepository, times(1)).deleteById(board.getId());
    }

    @Test
    void testGetBoardsByTeamId() {
        when(boardRepository.findAllByTeamId(team.getId())).thenReturn(List.of(board));
        when(boardConverter.fromEntityToResponseDto(board)).thenReturn(boardResponseDto);

        List<BoardResponseDto> result = boardServiceImpl.getBoardsByTeamId(team.getId());

        assertEquals(result.get(0).getCreateDateTime(), boardResponseDto.getCreateDateTime());
        assertEquals(result.get(0).getTitle(), boardResponseDto.getTitle());
        assertEquals(result.get(0).getTeamId(), boardResponseDto.getTeamId());
    }

    @Test
    void should_throwBoardNotUpdatedException_when_boardDoesntExist() {
        Exception exception = assertThrows(BoardNotUpdated.class, () -> boardServiceImpl.updateBoardById(boardRequestDto));

        String expectedMessage = "Board: " + board.getId() + " could not be updated.";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void should_throwBoardNotDeletedException_when_boardDoesntExist() {
        Exception exception = assertThrows(BoardNotDeleted.class, () -> boardServiceImpl.deleteBoard(board.getId()));

        String expectedMessage = "Board with id: " + board.getId() + " could not be deleted.";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void should_throwBoardNotFoundException_when_boardDoesntExist() {
        Exception exception = assertThrows(BoardNotFound.class, () -> boardServiceImpl.getBoardById(board.getId()));

        String expectedMessage = "Board with id: " + board.getId() + " could not be found.";

        assertEquals(expectedMessage, exception.getMessage());
    }
}
