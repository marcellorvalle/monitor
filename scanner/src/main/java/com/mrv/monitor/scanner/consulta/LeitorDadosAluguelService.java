package com.mrv.monitor.scanner.consulta;

import com.mrv.monitor.scanner.webclient.B3WebClient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Cacheable(value = "dadosAluguel")
    public DadosAluguel executar(String ticket) {
        var resposta = webClient
            .executar(ticket, LocalDate.now().format(formatter))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return extratorDados.executar(resposta);
    }
}
