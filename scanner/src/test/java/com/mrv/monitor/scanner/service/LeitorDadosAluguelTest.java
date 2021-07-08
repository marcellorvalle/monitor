package com.mrv.monitor.scanner.service;

import static org.junit.jupiter.api.Assertions.*;

import com.mrv.monitor.scanner.webclient.B3WebClient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

class LeitorDadosAluguelTest {
    private final LeitorDadosAluguel leitorDadosAluguel;

    public LeitorDadosAluguelTest() {
        leitorDadosAluguel =
            new LeitorDadosAluguel(new B3WebClient(), new ExtratorDadosAluguelService(), DateTimeFormatter.ISO_DATE);
    }

    @Test
    void deve() {
        System.out.println(leitorDadosAluguel.executar("PSSA3", LocalDate.now()));
        //arrange
        //act
        //assert
    }
}
