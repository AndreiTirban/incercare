package ro.fortech.whiteboard.domain.boards.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BoardResponseDto {
    @Schema(
            description = "Id of the board",
            type = "string",
            format = "uuid",
            example = "e69f0bc0-35e9-4c21-be98-b17169fdda14",
            required = true
    )
    private String id;

    @Schema(
            description = "Title of the board",
            type = "string",
            example = "My first board",
            required = true
    )
    private String title;

    @Schema(
            description = "Date when board was created",
            type = "string",
            format = "date-time",
            example = "2021-01-01T12:00:00Z",
            required = true
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime createDateTime;

    @Schema(
            description = "Id of team owning the board",
            type = "string",
            example = "e839734f-2301-42b1-bda2-1fb6cbac9001",
            required = true
    )
    private String teamId;
}
