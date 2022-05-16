package ro.fortech.whiteboard.domain.teams.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class TeamRequestDto {
  @Schema(
      description = "Id of the team",
      type = "string",
      format = "uuid",
      example = "e46c9ac4-389c-11ec-8d3d-0242ac130003"
  )
  private String id;

  @NotNull
  @Length(min = 2, max = 500)
  @Schema(
      description = "Name of the team",
      type = "string",
      example = "My first team",
      required = true
  )
  private String name;

  @Schema(
      description = "Number of team members",
      type = "integer",
      minimum = "0",
      maximum = "500"
  )
  private int numberOfUsers;
}
