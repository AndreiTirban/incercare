package ro.fortech.whiteboard.domain.teams.rest.exception;

public class TeamNotFound extends RuntimeException {

  public TeamNotFound(String message) {
    super(message);
  }
}
