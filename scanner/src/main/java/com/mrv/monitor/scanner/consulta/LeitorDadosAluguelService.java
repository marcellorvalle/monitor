package com.mrv.monitor.scanner.consulta;

import com.mrv.monitor.scanner.common.DadosAluguel;
import com.mrv.monitor.scanner.common.DadosCache;
import com.mrv.monitor.scanner.webclient.B3WebClient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class LeitorDadosAluguelService {

    private final B3WebClient webClient;
    private final ProcessadorDadosAluguelService extratorDados;

    private final DadosCache cache;

    public LeitorDadosAluguelService(
        B3WebClient webClient,
        ProcessadorDadosAluguelService extratorDados,
        DadosCache cache
    ) {
        this.webClient = webClient;
        this.extratorDados = extratorDados;
        this.cache = cache;
    }

    public Set<DadosAluguel> executar(Set<String> tickets) {
        return tickets.parallelStream().map(this::tryCache).collect(Collectors.toSet());
    }

    private DadosAluguel tryCache(String ticket) {
        return cache.computeIfAbsent(ticket, this::get);
    }

    public DadosAluguel get(String ticket) {
        var resposta = webClient.executar(ticket, LocalDate.now().format(DateTimeFormatter.ISO_DATE));

        return extratorDados.executar(resposta);
    }
}
