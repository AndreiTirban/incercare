package ro.fortech.whiteboard.domain.teams.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.fortech.whiteboard.domain.teams.TeamController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

@RestControllerAdvice(assignableTypes = TeamController.class)
public class TeamExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {ConstraintViolationException.class})
  protected void handleConstraintViolationException(ConstraintViolationException exception,
      HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
  }

  @ExceptionHandler(value = {TeamNotFound.class})
  protected void handleException(TeamNotFound exception, HttpServletResponse response)
      throws IOException {
    response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
  }

  @ExceptionHandler(value = {TeamNotDeleted.class})
  protected void handleException(TeamNotDeleted exception, HttpServletResponse response)
      throws IOException {
    response.sendError(HttpStatus.CONFLICT.value(), exception.getMessage());
  }

  @ExceptionHandler(value = {TeamNotUpdated.class})
  protected void handleException(TeamNotUpdated exception, HttpServletResponse response)
      throws IOException {
    response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
  }
}
