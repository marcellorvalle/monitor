package com.mrv.monitor.scanner.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DadosAluguel {
    private String ticket;
    private long numContratos;
    private double taxaMedia;
    private double taxaMaxima;
    private double taxaMinima;
    private long quantidade;
    private LocalDate data;

    public long negociosPorContrato() {
        return teveNegocios() ? quantidade / numContratos : 0;
    }

    public boolean teveNegocios() {
        return numContratos > 0;
    }
}
