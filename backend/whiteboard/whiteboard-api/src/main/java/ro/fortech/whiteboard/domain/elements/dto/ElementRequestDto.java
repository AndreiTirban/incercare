package ro.fortech.whiteboard.domain.elements.dto;

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
public class ElementRequestDto {
    @Schema(
            description = "Id of the element",
            type = "string",
            format = "uuid",
            example = "9c0c3001-52df-4b81-9d5a-de0470d4797"
    )
    private String id;

    @NotNull
    @Length(min = 2, max = 255)
    @Schema(
            description = "Element Text",
            type = "string",
            example = "Hello World!",
            required = true
    )
    private String text;
}
