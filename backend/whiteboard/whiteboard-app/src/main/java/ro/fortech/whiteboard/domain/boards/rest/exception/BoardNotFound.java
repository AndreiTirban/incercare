package ro.fortech.whiteboard.domain.boards.rest.exception;

public class BoardNotFound extends RuntimeException {

    public BoardNotFound(String message) {
        super(message);
    }
}
