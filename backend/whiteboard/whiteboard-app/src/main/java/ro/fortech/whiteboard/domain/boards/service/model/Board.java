package ro.fortech.whiteboard.domain.boards.service.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "BOARDS")
public class Board {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "ID", length = 36, nullable = false, updatable = false)
    private String id;

    @Column(name = "TITLE", nullable = false, length = 500)
    private String title;

    @Column(name = "CREATE_DATE_TIME", nullable = false)
    private LocalDateTime createDateTime;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private TeamEntity team;
}
