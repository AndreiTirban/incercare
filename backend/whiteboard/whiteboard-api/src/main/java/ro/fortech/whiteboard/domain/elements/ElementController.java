package ro.fortech.whiteboard.domain.elements;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.fortech.whiteboard.domain.elements.dto.ElementRequestDto;
import ro.fortech.whiteboard.domain.elements.dto.ElementResponseDto;

@RequestMapping(path = "/element")
public interface ElementController {

    @Operation(summary = "Create Element")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Element Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint", content = @Content)
    })
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    ElementResponseDto createElement(@RequestBody ElementRequestDto elementRequestDto);

    @Operation(summary = "Get Element by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Element not found.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint", content = @Content)
    })
    @GetMapping(path = "/find/{id}")
    ElementResponseDto getElementById(@PathVariable String id);

    @Operation(summary = "Update an element")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Element could not be updated."),
            @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint")
    })
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateElementById(@RequestBody ElementRequestDto elementRequestDto);

    @Operation(summary = "Delete an element")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Element could not be deleted."),
            @ApiResponse(responseCode = "403", description = "Currently logged in user cannot access this endpoint")
    })
    @DeleteMapping(path = "/delete/{id}")
    void deleteElementById(@PathVariable String id);
}
