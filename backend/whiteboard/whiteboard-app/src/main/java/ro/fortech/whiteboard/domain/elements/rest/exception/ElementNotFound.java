package ro.fortech.whiteboard.domain.elements.rest.exception;

public class ElementNotFound extends RuntimeException {
    public ElementNotFound(String message) {
        super(message);
    }
}
