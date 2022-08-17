package com.mrv.monitor.scanner.consulta;

import java.time.LocalDate;

public record DadosAluguel(
    String ticket,
    long numContratos,
    double taxaMedia,
    double taxaMaxima,
    double taxaMinima,
    long quantidade,
    LocalDate data
) {
    public long papeisPorContrato() {
        return teveNegocios() ? quantidade / numContratos : 0;
    }

    public boolean teveNegocios() {
        return numContratos > 0;
    }
}
