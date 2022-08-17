package com.mrv.monitor.scanner.consulta;

import com.mrv.monitor.scanner.webclient.B3WebClient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class LeitorDadosAluguelServiceTest {

    private final LeitorDadosAluguelService leitorDadosAluguelService;

    public LeitorDadosAluguelServiceTest() {
        leitorDadosAluguelService =
            new LeitorDadosAluguelService(
                new B3WebClient(),
                new ProcessadorDadosAluguelService(),
                DateTimeFormatter.ISO_DATE
            );
    }

    @Test
    void deve() {
        Stream
            .of("CIEL3", "EGIE3", "EZTC3", "HYPE3", "ODPV3", "PSSA3", "RADL3")
            .parallel()
            .map(t -> leitorDadosAluguelService.executar(t, LocalDate.now()))
            .forEach(System.out::println);
        //System.out.println(leitorDadosAluguel.executar("PSSA3", LocalDate.now()));
        //arrange
        //act
        //assert
    }
}
