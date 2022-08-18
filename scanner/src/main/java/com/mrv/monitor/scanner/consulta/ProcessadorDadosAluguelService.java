package com.mrv.monitor.scanner.consulta;

import com.mrv.monitor.scanner.common.DadosAluguel;
import com.mrv.monitor.scanner.webclient.Resposta;
import java.time.LocalDate;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
class ProcessadorDadosAluguelService {

    DadosAluguel executar(Resposta resposta) {
        return new DadosAluguel(
            resposta.name(),
            resposta.detalhes().size(),
            taxaMedia(resposta.detalhes()),
            taxaMaxima(resposta.detalhes()),
            taxaMinima(resposta.detalhes()),
            quantidade(resposta.detalhes()),
            LocalDate.now()
        );
    }

    private double taxaMedia(Set<Resposta.Detalhe> detalhes) {
        var taxa = detalhes.stream().mapToDouble(Resposta.Detalhe::taxa).average().orElse(Double.NaN);

        return Math.round(taxa * 100.0) / 100.0;
    }

    private double taxaMinima(Set<Resposta.Detalhe> detalhes) {
        return detalhes.stream().mapToDouble(Resposta.Detalhe::taxa).min().orElse(Double.NaN);
    }

    private double taxaMaxima(Set<Resposta.Detalhe> detalhes) {
        return detalhes.stream().mapToDouble(Resposta.Detalhe::taxa).max().orElse(Double.NaN);
    }

    private long quantidade(Set<Resposta.Detalhe> detalhes) {
        return detalhes.stream().mapToLong(Resposta.Detalhe::quantidade).max().orElse(0);
    }
}
