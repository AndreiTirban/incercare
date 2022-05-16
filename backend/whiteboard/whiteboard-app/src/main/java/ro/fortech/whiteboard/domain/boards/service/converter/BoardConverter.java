package ro.fortech.whiteboard.domain.boards.service.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ro.fortech.whiteboard.domain.boards.dto.BoardRequestDto;
import ro.fortech.whiteboard.domain.boards.dto.BoardResponseDto;
import ro.fortech.whiteboard.domain.boards.service.model.Board;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Configuration
public class BoardConverter {
    private final ModelMapper modelMapper;

    public Board fromRequestDtoToEntity(BoardRequestDto boardRequestDto) {
        return modelMapper.map(boardRequestDto, Board.class);
    }

    public BoardResponseDto fromEntityToResponseDto(Board board) {
        return modelMapper.map(board, BoardResponseDto.class);
    }
}
