package ro.fortech.whiteboard.domain.elements.service.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "ELEMENTS")
public class Element {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "ID", length = 36, nullable = false, updatable = false)
    private String id;

    @Column(name = "TEXT", nullable = false)
    private String text;
}
