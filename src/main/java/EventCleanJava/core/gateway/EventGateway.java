package EventCleanJava.core.gateway;

import EventCleanJava.core.entities.Event;
import java.util.List;
import java.util.Optional;

public interface EventGateway {

    Event novoEvento(Event event);
    List<Event> buscarEvento();
    boolean existePorIdentificador(String identificador);
    Optional<Event> eventId(String identificador);



    // 3 - Aqui no gateway(core) é que define a regra inicial de como o method irá ser utilizado lá no outro gateway(infra)
    // Vai me gerar um erro lá no gateway(infra) porque é preciso definir a regra final do method
    // Esse gateway não tem contexto com as camadas de abstração do core. É necessário criar um contexto(Bean) para as 3 camadas se conectarem: Case, CaseIMPL e gateway
}
