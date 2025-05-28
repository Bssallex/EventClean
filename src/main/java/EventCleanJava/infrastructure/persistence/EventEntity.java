package EventCleanJava.infrastructure.persistence;

import EventCleanJava.core.enums.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "Eventos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String identificador;

    private String organizador;

    private String localEvento;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
