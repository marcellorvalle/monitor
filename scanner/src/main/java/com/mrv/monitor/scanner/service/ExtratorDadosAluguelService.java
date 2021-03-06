package com.mrv.monitor.scanner.service;

import com.mrv.monitor.scanner.model.DadosAluguel;
import com.mrv.monitor.scanner.webclient.Resposta;
import java.time.LocalDate;
import java.util.Set;

public class ExtratorDadosAluguelService {

    public DadosAluguel executar(Resposta resposta) {
        var dados = new DadosAluguel();
        dados.setTicket(resposta.getName());
        dados.setNumContratos(resposta.detalhes().size());
        dados.setTaxaMedia(taxaMedia(resposta.detalhes()));
        dados.setTaxaMaxima(taxaMaxima(resposta.detalhes()));
        dados.setTaxaMinima(taxaMinima(resposta.detalhes()));
        dados.setQuantidade(quantidade(resposta.detalhes()));
        dados.setData(LocalDate.now());

        return dados;
    }

    private double taxaMedia(Set<Resposta.Detalhes> detalhes) {
        var taxa = detalhes.stream().mapToDouble(Resposta.Detalhes::getTaxa).average().orElse(Double.NaN);

        return Math.round(taxa * 100.0) / 100.0;
    }

    private double taxaMinima(Set<Resposta.Detalhes> detalhes) {
        return detalhes.stream().mapToDouble(Resposta.Detalhes::getTaxa).min().orElse(Double.NaN);
    }

    private double taxaMaxima(Set<Resposta.Detalhes> detalhes) {
        return detalhes.stream().mapToDouble(Resposta.Detalhes::getTaxa).max().orElse(Double.NaN);
    }

    private long quantidade(Set<Resposta.Detalhes> detalhes) {
        return detalhes.stream().mapToLong(Resposta.Detalhes::getQuantidade).max().orElse(0);
    }
}
