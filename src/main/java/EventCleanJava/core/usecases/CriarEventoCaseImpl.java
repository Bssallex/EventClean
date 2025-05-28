package EventCleanJava.core.usecases;

import EventCleanJava.core.entities.Event;
import EventCleanJava.core.gateway.EventGateway;
import EventCleanJava.infrastructure.exceptions.DuplicateEventExceptions;

public class CriarEventoCaseImpl implements CriarEventoCase{

    private final EventGateway eventGateway;

    public CriarEventoCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        if(eventGateway.existePorIdentificador(event.identificador())){
             throw new DuplicateEventExceptions("Atenção! O identificador: " + event.identificador() + " já está em uso");
        }
        return eventGateway.novoEvento(event);
    }
}
