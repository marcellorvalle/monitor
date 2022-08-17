package com.mrv.monitor.scanner.service;

import com.mrv.monitor.scanner.webclient.B3WebClient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class LeitorDadosAluguelTest {

    private final LeitorDadosAluguel leitorDadosAluguel;

    public LeitorDadosAluguelTest() {
        leitorDadosAluguel =
            new LeitorDadosAluguel(new B3WebClient(), new ProcessadorDadosAluguelService(), DateTimeFormatter.ISO_DATE);
    }

    @Test
    void deve() {
        Stream
            .of("CIEL3", "EGIE3", "EZTC3", "HYPE3", "ODPV3", "PSSA3", "RADL3")
            .parallel()
            .map(t -> leitorDadosAluguel.executar(t, LocalDate.now()))
            .forEach(System.out::println);
        //System.out.println(leitorDadosAluguel.executar("PSSA3", LocalDate.now()));
        //arrange
        //act
        //assert
    }
}
