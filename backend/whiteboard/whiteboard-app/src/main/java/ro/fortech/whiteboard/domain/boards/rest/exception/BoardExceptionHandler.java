package ro.fortech.whiteboard.domain.boards.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.fortech.whiteboard.domain.boards.BoardController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

@RestControllerAdvice(assignableTypes = BoardController.class)
public class BoardExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected void handleConstraintViolationException(ConstraintViolationException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(value = {BoardNotFound.class})
    protected void handleBoardNotFoundException(BoardNotFound exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(value = {BoardNotDeleted.class})
    protected void handleBoardNotDeletedException(BoardNotDeleted exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(value = {BoardNotUpdated.class})
    protected void handleBoardNotUpdatedException(BoardNotUpdated exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }
}
