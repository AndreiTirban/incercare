package ro.fortech.whiteboard.domain.boards.service;

import org.springframework.stereotype.Service;
import ro.fortech.whiteboard.domain.boards.dto.BoardRequestDto;
import ro.fortech.whiteboard.domain.boards.dto.BoardResponseDto;

import javax.validation.Valid;
import java.util.List;

@Service
public interface BoardService {
    BoardResponseDto createBoard(@Valid BoardRequestDto boardRequestDto);

    BoardResponseDto getBoardById(String id);

    void updateBoardById(@Valid BoardRequestDto boardRequestDto);

    void deleteBoard(String id);

    List<BoardResponseDto> getBoardsByTeamId(String teamId);
}
