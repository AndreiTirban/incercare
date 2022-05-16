package ro.fortech.whiteboard.domain.teams.rest.exception;

public class TeamNotDeleted extends RuntimeException {

  public TeamNotDeleted(String message) {
    super(message);
  }
}
