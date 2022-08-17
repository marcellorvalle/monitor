package com.mrv.monitor.scanner.consulta;

import com.mrv.monitor.scanner.webclient.B3WebClient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

@Service
public class LeitorDadosAluguelService {

    private final B3WebClient webClient;
    private final ProcessadorDadosAluguelService extratorDados;
    private final DateTimeFormatter formatter;

    public LeitorDadosAluguelService(
        B3WebClient webClient,
        ProcessadorDadosAluguelService extratorDados,
        DateTimeFormatter formatter
    ) {
        this.webClient = webClient;
        this.extratorDados = extratorDados;
        this.formatter = formatter;
    }

    public DadosAluguel executar(String ticket, LocalDate data) {
        var resposta = webClient.executar(ticket, data.format(formatter));

        return extratorDados.executar(resposta);
    }
}
