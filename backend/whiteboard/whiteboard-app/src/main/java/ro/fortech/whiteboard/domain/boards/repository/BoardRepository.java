package ro.fortech.whiteboard.domain.boards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.whiteboard.domain.boards.service.model.Board;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {
    List<Board> findAllByTeamId(String teamId);
}
