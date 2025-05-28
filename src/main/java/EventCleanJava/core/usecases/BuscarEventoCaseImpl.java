package EventCleanJava.core.usecases;

import EventCleanJava.core.entities.Event;
import EventCleanJava.core.gateway.EventGateway;
import java.util.List;

public class BuscarEventoCaseImpl implements BuscarEventoCase{

    private final EventGateway eventGateway;

    public BuscarEventoCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.buscarEvento();
    }

    // 2 - Segunda regra de funcionalidade
    // Sempre é necessário passar o gateway(core) no retorno porque o gateway(infra) busca o method já pronto para só implementar o JPA
}
