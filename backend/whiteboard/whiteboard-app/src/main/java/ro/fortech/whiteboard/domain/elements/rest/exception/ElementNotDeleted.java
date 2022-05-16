package ro.fortech.whiteboard.domain.elements.rest.exception;

public class ElementNotDeleted extends RuntimeException {
    public ElementNotDeleted(String message) {
        super(message);
    }
}
