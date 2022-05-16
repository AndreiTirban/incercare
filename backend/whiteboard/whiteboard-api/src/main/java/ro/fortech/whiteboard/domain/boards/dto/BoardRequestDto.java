package ro.fortech.whiteboard.domain.boards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Valid
public class BoardRequestDto {
    @Schema(
            description = "Id of the board",
            type = "string",
            format = "uuid",
            example = "e69f0bc0-35e9-4c21-be98-b17169fdda14"
    )
    private String id;

    @NotNull
    @Length(min = 2, max = 500)
    @Schema(
            description = "Title of the board",
            type = "string",
            example = "My first board",
            required = true
    )
    private String title;

    @NotNull
    @Schema(
            description = "Id of team owning the board",
            type = "string",
            example = "e839734f-2301-42b1-bda2-1fb6cbac9001",
            required = true
    )
    private String teamId;
}
