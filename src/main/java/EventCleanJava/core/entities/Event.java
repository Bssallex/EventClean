package EventCleanJava.core.entities;

import EventCleanJava.core.enums.Tipo;
import java.time.LocalDateTime;

public record Event(Long id,
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
