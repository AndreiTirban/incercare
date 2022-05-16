package ro.fortech.whiteboard.domain.boards.service.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import ro.fortech.whiteboard.domain.boards.BoardFactory;
import ro.fortech.whiteboard.domain.boards.dto.BoardRequestDto;
import ro.fortech.whiteboard.domain.boards.dto.BoardResponseDto;
import ro.fortech.whiteboard.domain.boards.service.model.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BoardConverterTest {

    private Board board;
    private BoardRequestDto boardRequestDto;
    private BoardResponseDto boardResponseDto;

    @BeforeEach
    void setUp() {
        board = BoardFactory.getBoard();
        boardRequestDto = BoardFactory.getBoardRequestDto();
        boardResponseDto = BoardFactory.getBoardResponseDto();
    }

    @InjectMocks
    private BoardConverter boardConverter;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void testMapFromRequestDtoToEntity() {
        when(modelMapper.map(boardRequestDto, Board.class)).thenReturn(board);

        Board result = boardConverter.fromRequestDtoToEntity(boardRequestDto);

        assertEquals(result.getTitle(), board.getTitle());
        assertEquals(result.getCreateDateTime(), board.getCreateDateTime());
    }

    @Test
    void testMapFromEntityToResponseDto() {
        when(modelMapper.map(board, BoardResponseDto.class)).thenReturn(boardResponseDto);

        BoardResponseDto result = boardConverter.fromEntityToResponseDto(board);

        assertEquals(result.getTitle(), boardResponseDto.getTitle());
        assertEquals(result.getCreateDateTime(), boardResponseDto.getCreateDateTime());
    }
}
