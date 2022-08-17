package com.mrv.monitor.scanner.consulta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadosAluguelController {

    private final LeitorDadosAluguelService leitorDadosAluguelService;

    public DadosAluguelController(LeitorDadosAluguelService leitorDadosAluguelService) {
        this.leitorDadosAluguelService = leitorDadosAluguelService;
    }

    @GetMapping("/dados-aluguel/{ticket}")
    public DadosAluguel getById(@PathVariable("ticket") String ticket) {
        return leitorDadosAluguelService.executar(ticket.toUpperCase());
    }
}
