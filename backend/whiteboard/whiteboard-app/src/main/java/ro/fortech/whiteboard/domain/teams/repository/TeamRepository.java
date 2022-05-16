package ro.fortech.whiteboard.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, String> {

}
