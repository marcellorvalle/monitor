package com.mrv.monitor.scanner.common;

import java.time.LocalDate;

public record DadosAluguel(
    String ticket,
    long numContratos,
    double taxaMedia,
    double taxaMaxima,
    double taxaMinima,
    long quantidade,
    LocalDate data
)
    implements Comparable<DadosAluguel> {
    public long getPapeisPorContrato() {
        return getTeveNegocios() ? quantidade / numContratos : 0;
    }

    public boolean getTeveNegocios() {
        return numContratos > 0;
    }

    @Override
    public int compareTo(DadosAluguel o) {
        return taxaMedia > o.taxaMedia ? 1 : -1;
    }
}
