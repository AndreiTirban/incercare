package ro.fortech.whiteboard.domain.boards.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ro.fortech.whiteboard.domain.boards.dto.BoardRequestDto;
import ro.fortech.whiteboard.domain.boards.dto.BoardResponseDto;
import ro.fortech.whiteboard.domain.boards.repository.BoardRepository;
import ro.fortech.whiteboard.domain.boards.rest.exception.BoardNotDeleted;
import ro.fortech.whiteboard.domain.boards.rest.exception.BoardNotFound;
import ro.fortech.whiteboard.domain.boards.rest.exception.BoardNotUpdated;
import ro.fortech.whiteboard.domain.boards.service.converter.BoardConverter;
import ro.fortech.whiteboard.domain.boards.service.model.Board;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    @Override
    public BoardResponseDto createBoard(@Valid BoardRequestDto boardRequestDto) {
        Board board = boardConverter.fromRequestDtoToEntity(boardRequestDto);
        board.setCreateDateTime(LocalDateTime.now());
        boardRepository.save(board);

        return boardConverter.fromEntityToResponseDto(board);
    }

    @Override
    public BoardResponseDto getBoardById(String id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFound(boarNotFoundExceptionMessage(id)));

        return boardConverter.fromEntityToResponseDto(board);
    }

    @Override
    public void updateBoardById(@Valid BoardRequestDto boardRequestDto) {
        String boardId = boardRequestDto.getId();

        try {
            if (boardRepository.existsById(boardId)) {
                Board board = boardConverter.fromRequestDtoToEntity(boardRequestDto);
                board.setCreateDateTime(LocalDateTime.now());
                boardRepository.save(board);
            } else throw new BoardNotFound(boarNotFoundExceptionMessage(boardId));

        } catch (Exception exception) {
            throw new BoardNotUpdated("Board: " + boardId + " could not be updated.");
        }
    }

    @Override
    public List<BoardResponseDto> getBoardsByTeamId(String teamId) {
        return boardRepository.findAllByTeamId(teamId).stream()
                .map(boardConverter::fromEntityToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBoard(String id) {
        try {
            if (boardRepository.existsById(id)) {
                boardRepository.deleteById(id);
            } else throw new BoardNotFound(boarNotFoundExceptionMessage(id));

        } catch (Exception exception) {
            throw new BoardNotDeleted("Board with id: " + id + " could not be deleted.");
        }
    }

    private static String boarNotFoundExceptionMessage(String id) {
        return "Board with id: " + id + " could not be found.";
    }
}
