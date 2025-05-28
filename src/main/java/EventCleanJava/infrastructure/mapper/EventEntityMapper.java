package EventCleanJava.infrastructure.mapper;

import EventCleanJava.core.entities.Event;
import EventCleanJava.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event){

        return new EventEntity(
                event.id(),
                event.nome(),
                event.descricao(),
                event.identificador(),
                event.organizador(),
                event.localEvento(),
                event.dataInicio(),
                event.dataFim(),
                event.capacidade(),
                event.tipo()
        );
    }

    public Event toDomain(EventEntity eventEntity){

        return new Event(
                eventEntity.getId(),
                eventEntity.getNome(),
                eventEntity.getDescricao(),
                eventEntity.getIdentificador(),
                eventEntity.getOrganizador(),
                eventEntity.getLocalEvento(),
                eventEntity.getDataInicio(),
                eventEntity.getDataFim(),
                eventEntity.getCapacidade(),
                eventEntity.getTipo()
        );
    }
}
