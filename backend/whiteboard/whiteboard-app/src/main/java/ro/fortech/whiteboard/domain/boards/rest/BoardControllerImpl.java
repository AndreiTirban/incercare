package ro.fortech.whiteboard.domain.boards.rest;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.fortech.whiteboard.domain.boards.BoardController;
import ro.fortech.whiteboard.domain.boards.dto.BoardRequestDto;
import ro.fortech.whiteboard.domain.boards.dto.BoardResponseDto;
import ro.fortech.whiteboard.domain.boards.service.BoardServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Tag(name = "Board API", description = "<h4> Board API performing CRUD operations </h4>")
public class BoardControllerImpl implements BoardController {
    private final BoardServiceImpl boardServiceImpl;

    @Override
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        return boardServiceImpl.createBoard(boardRequestDto);
    }

    @Override
    public BoardResponseDto getBoardById(@PathVariable @Parameter(description = "Id of the board that we want to get",
            example = "4b145d36-11e7-412f-87ef-8e30fac52788",
            required = true) String id) {
        return boardServiceImpl.getBoardById(id);
    }

    @Override
    public void updateBoardById(@RequestBody BoardRequestDto boardRequestDto) {
        boardServiceImpl.updateBoardById(boardRequestDto);
    }

    @Override
    public void deleteBoard(@PathVariable @Parameter(description = "Id of the board that we want to delete",
            example = "4b145d36-11e7-412f-87ef-8e30fac52788",
            required = true
    ) String id) {
        boardServiceImpl.deleteBoard(id);
    }

    @Override
    public List<BoardResponseDto> getBoardsByTeamId(@PathVariable String teamId) {
        return boardServiceImpl.getBoardsByTeamId(teamId);
    }
}
