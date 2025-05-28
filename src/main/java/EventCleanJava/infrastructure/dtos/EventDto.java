package EventCleanJava.infrastructure.dtos;

import EventCleanJava.core.enums.Tipo;
import java.time.LocalDateTime;

public record EventDto(Long id,
                       String nome,
                       String descricao,
                       String identificador,
                       String localEvento,
                       String organizador,
                       LocalDateTime dataInicio,
                       LocalDateTime dataFim,
                       Integer capacidade,
                       Tipo tipo) {
}
