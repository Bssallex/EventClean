package EventCleanJava.core.usecases;

import EventCleanJava.core.entities.Event;
import EventCleanJava.core.gateway.EventGateway;
import EventCleanJava.infrastructure.exceptions.NotFoundEventExceptions;

public class FiltrarIdentificadorImpl implements FiltrarIdentificadorCase {

    private final EventGateway gateway;

    public FiltrarIdentificadorImpl(EventGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Event execute(String identificador) {
        return gateway.eventId(identificador).
                orElseThrow(() -> new NotFoundEventExceptions("Atenção! Identificador: " + identificador + " não encontrado"));
    }
}
