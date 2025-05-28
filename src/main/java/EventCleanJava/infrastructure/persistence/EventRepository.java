package EventCleanJava.infrastructure.persistence;

import EventCleanJava.core.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Optional<Event> findByIdentificador(String identificador);
}
