package ro.fortech.whiteboard.domain.teams;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import ro.fortech.whiteboard.domain.teams.dto.TeamRequestDto;
import ro.fortech.whiteboard.domain.teams.dto.TeamResponseDto;

@RequestMapping(path = "/teams")
public interface TeamController {

  @Operation(summary = "Create team")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Team created"),
      @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
      @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint", content = @Content)
  })
  @PostMapping("/create")
  TeamResponseDto addTeam(@RequestBody TeamRequestDto teamRequestDto);

  @Operation(summary = "Get team by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success"),
      @ApiResponse(responseCode = "404", description = "Team not found.", content = @Content),
      @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint", content = @Content)
  })
  @GetMapping("/find/{id}")
  TeamResponseDto getTeamById(@PathVariable String id);

  @Operation(summary = "Update a team")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Team has been successfully deleted."),
      @ApiResponse(responseCode = "400", description = "Team could not be updated."),
      @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint")
  })
  @PutMapping("/update")
  void updateTeamById(@RequestBody TeamRequestDto teamRequestDto);

  @Operation(summary = "Delete a team by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Team has been successfully deleted."),
      @ApiResponse(responseCode = "400", description = "Team could not be deleted."),
      @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint")
  })
  @DeleteMapping("/delete/{id}")
  void deleteTeamById(@PathVariable String id);
}
