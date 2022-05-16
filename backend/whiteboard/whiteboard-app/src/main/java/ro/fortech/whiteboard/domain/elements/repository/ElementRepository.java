package ro.fortech.whiteboard.domain.elements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.whiteboard.domain.elements.service.model.Element;

@Repository
public interface ElementRepository extends JpaRepository<Element, String> {
}
