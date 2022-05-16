package ro.fortech.whiteboard.domain.elements.rest.exception;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.fortech.whiteboard.domain.elements.ElementController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

@Log
@RestControllerAdvice(assignableTypes = ElementController.class)
public class ElementExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected void handleConstraintViolationException(ConstraintViolationException exception, HttpServletResponse response) throws IOException {
        log.warning(exception.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(value = {ElementNotFound.class})
    protected void handleElementNotFoundException(ElementNotFound exception, HttpServletResponse response) throws IOException {
        log.warning(exception.getMessage());
        response.sendError(HttpStatus.NOT_FOUND.value(),exception.getMessage());
    }

    @ExceptionHandler(value = {ElementNotDeleted.class})
    protected void handleElementNotDeletedException(ElementNotDeleted exception, HttpServletResponse response) throws IOException {
        log.warning(exception.getMessage());
        response.sendError(HttpStatus.CONFLICT.value(),exception.getMessage());
    }

    @ExceptionHandler(value = {ElementNotUpdated.class})
    protected void handleElementNotUpdatedException(ElementNotUpdated exception, HttpServletResponse response) throws IOException {
        log.warning(exception.getMessage());
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage());
    }
}
