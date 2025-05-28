package EventCleanJava.infrastructure.bean;

import EventCleanJava.core.gateway.EventGateway;
import EventCleanJava.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CriarEventoCase criarEventoCase(EventGateway gateway){
        return new CriarEventoCaseImpl(gateway);
    }

    @Bean
    public BuscarEventoCase buscarEventoCase(EventGateway gateway){
        return new BuscarEventoCaseImpl(gateway);
    }

    @Bean
    public FiltrarIdentificadorCase filtrarIdentificadorCase(EventGateway gateway){
        return new FiltrarIdentificadorImpl(gateway);
    }
}
