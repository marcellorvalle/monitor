package com.mrv.monitor.scanner.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosAluguel {
    private String ticket;
    private long numContratos;
    private double taxaMedia;
    private double taxaMaxima;
    private double taxaMinima;
    private long quantidade;
    private LocalDate data;
}
