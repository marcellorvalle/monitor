package com.mrv.monitor.scanner.consulta;

import com.mrv.monitor.scanner.common.DadosCache;
import com.mrv.monitor.scanner.webclient.B3WebClient;
import java.util.Comparator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LeitorDadosAluguelServiceTest {

    private final LeitorDadosAluguelService leitorDadosAluguelService;

    public LeitorDadosAluguelServiceTest() {
        leitorDadosAluguelService =
            new LeitorDadosAluguelService(
                new B3WebClient(),
                new ProcessadorDadosAluguelService(),
                Mockito.mock(DadosCache.class)
            );
    }

    @Test
    void deve() {
        var results = papeis()
            .map(leitorDadosAluguelService::get)
            .filter(d -> d.numContratos() > 1 && d.taxaMedia() >= 1)
            .sorted(Comparator.reverseOrder())
            .toList();

        results.forEach(System.out::println);
    }

    private Stream<String> papeis() {
        return Stream
            .of(
                "ABEV3",
                "B3SA3",
                "BBDC3",
                "BBAS3",
                "CCRO3",
                "CIEL3",
                "EGIE3",
                "EZTC3",
                "FLRY3",
                "CGRA4",
                "GRND3",
                "HYPE3",
                "ITUB3",
                "LREN3",
                "MDIA3",
                "MGLU3",
                "LEVE3",
                "ODPV3",
                "PSSA3",
                "RADL3",
                "TOTS3",
                "WEGE3",
                "ABCP11",
                "BBPO11",
                "BCFF11",
                "BRCR11",
                "BTLG11",
                "HGLG11",
                "HGRU11",
                "HGPO11",
                "PQDP11",
                "FEXC11",
                "VRTA11",
                "EDGA11",
                "GGRC11",
                "HGBS11",
                "HGRE11",
                "KNRI11",
                "MAXR11",
                "MXRF11",
                "FIIP11B",
                "RBRD11",
                "RCRB11",
                "RBVA11",
                "RNGO11",
                "SDIL11",
                "VISC11"
            )
            .parallel();
    }
}
