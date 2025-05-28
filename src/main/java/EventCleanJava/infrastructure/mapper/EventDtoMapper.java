package EventCleanJava.infrastructure.mapper;

import EventCleanJava.core.entities.Event;
import EventCleanJava.infrastructure.dtos.EventDto;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {

    public EventDto toDto(Event event){
        return new EventDto(
                event.id(),
                event.nome(),
                event.descricao(),
                event.identificador(),
                event.localEvento(),
                event.organizador(),
                event.dataInicio(),
                event.dataFim(),
                event.capacidade(),
                event.tipo()
        );
    }

    public Event toEvent(EventDto dto){
        return new Event(
                dto.id(),
                dto.nome(),
                dto.descricao(),
                dto.identificador(),
                dto.localEvento(),
                dto.organizador(),
                dto.dataInicio(),
                dto.dataFim(),
                dto.capacidade(),
                dto.tipo()
        );
    }
}
