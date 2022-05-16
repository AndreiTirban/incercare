package ro.fortech.whiteboard.domain.boards.rest.exception;

public class BoardNotDeleted extends RuntimeException {

    public BoardNotDeleted(String message) {
        super(message);
    }
}
