package ro.fortech.whiteboard.domain.boards;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.fortech.whiteboard.domain.boards.dto.BoardRequestDto;
import ro.fortech.whiteboard.domain.boards.dto.BoardResponseDto;

import java.util.List;

@RequestMapping("/board")
public interface BoardController {

    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Create board")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Board created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint", content = @Content)
    })
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto);

    @Operation(summary = "Get board by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Board not found.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint", content = @Content)
    })
    @GetMapping(path = "/find/{id}")
    BoardResponseDto getBoardById(@PathVariable String id);

    @Operation(summary = "Update a board")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Board has been successfully updated."),
            @ApiResponse(responseCode = "400", description = "Board could not be updated"),
            @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint")
    })
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateBoardById(@RequestBody BoardRequestDto boardRequestDto);

    @Operation(summary = "Delete a board")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Board has been successfully deleted."),
            @ApiResponse(responseCode = "400", description = "Board could not be deleted."),
            @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint")
    })
    @DeleteMapping(path = "/delete/{id}")
    void deleteBoard(@PathVariable String id);

    @Operation(summary = "Get all boards of a team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint")
    })
    @GetMapping("/find-boards/{teamId}")
    List<BoardResponseDto> getBoardsByTeamId(@PathVariable String teamId);
}
