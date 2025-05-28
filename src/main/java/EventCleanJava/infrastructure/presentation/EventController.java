package EventCleanJava.infrastructure.presentation;

import EventCleanJava.core.entities.Event;
import EventCleanJava.core.usecases.BuscarEventoCase;
import EventCleanJava.core.usecases.CriarEventoCase;
import EventCleanJava.core.usecases.FiltrarIdentificadorCase;
import EventCleanJava.infrastructure.dtos.EventDto;
import EventCleanJava.infrastructure.mapper.EventDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class EventController {

    private final CriarEventoCase criarEventoCase;
    private final BuscarEventoCase buscarEventoCase;
    private final FiltrarIdentificadorCase filtrarIdentificadorCase;

    private final EventDtoMapper eventDtoMapper;

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventDto eventDto){
        Event novoEvento = criarEventoCase.execute(eventDtoMapper.toEvent(eventDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "Evento criado com sucesso!");
        response.put("Dados do evento: ", eventDtoMapper.toDto(novoEvento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("buscarevento")
    public List<EventDto> buscarEventos(){
        List<Event> buscar = buscarEventoCase.execute();
        return buscar.stream()
                .map(eventDtoMapper::toDto)
                .toList();
    }

    @GetMapping("identificador/{identificador}")
    public ResponseEntity<Event> buscarPorIdentificador(@PathVariable String identificador){
       Event buscarId = filtrarIdentificadorCase.execute(identificador);
       return ResponseEntity.ok(buscarId);
    }



    // 5 - Definir o endpoint da API
    // Não tem como acessar o method diretamente do gateway porque ele é uma classe que implementa uma abstração
    // É necessário instanciar a dependecia do caso de uso para utilizar o method
}
