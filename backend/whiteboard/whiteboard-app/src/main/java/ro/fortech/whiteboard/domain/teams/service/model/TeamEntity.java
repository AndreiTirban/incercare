package ro.fortech.whiteboard.domain.teams.service.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ro.fortech.whiteboard.domain.boards.service.model.Board;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TEAM")
public class TeamEntity {

  @Id
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
  @Column(length = 36, nullable = false, updatable = false)
  private String id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "NUMBER_OF_USERS")
  private int numberOfUsers;

  @OneToMany(mappedBy = "team")
  private Set<Board> boards;
}
