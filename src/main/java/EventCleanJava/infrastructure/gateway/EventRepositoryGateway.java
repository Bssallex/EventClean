package EventCleanJava.infrastructure.gateway;

import EventCleanJava.core.entities.Event;
import EventCleanJava.core.gateway.EventGateway;
import EventCleanJava.infrastructure.mapper.EventEntityMapper;
import EventCleanJava.infrastructure.persistence.EventEntity;
import EventCleanJava.infrastructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event novoEvento(Event event) {
        EventEntity entity = eventEntityMapper.toEntity(event);
        EventEntity novoEvento = eventRepository.save(entity);
        return eventEntityMapper.toDomain(novoEvento);
    }

    @Override
    public List<Event> buscarEvento() {
        List<EventEntity> entity = eventRepository.findAll();
        return entity.stream()
                .map(eventEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return eventRepository.findAll()
                .stream()
                .anyMatch(evento -> evento.getIdentificador().equalsIgnoreCase(identificador));
    }

    @Override
    public Optional<Event> eventId(String identificador) {
        return eventRepository.findByIdentificador(identificador);
    }


    // Depois de definir todas as regras iniciais lá no core
    // 4 - Agora é necessário implementar o method e definir a regra final utilizando o JPA
    // Ir para o controller definir o endpoint
}
