package com.mrv.monitor.scanner.consulta;

import com.mrv.monitor.scanner.common.DadosAluguel;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadosAluguelController {

    private final LeitorDadosAluguelService leitorDadosAluguelService;

    public DadosAluguelController(LeitorDadosAluguelService leitorDadosAluguelService) {
        this.leitorDadosAluguelService = leitorDadosAluguelService;
    }

    @GetMapping("/dados-aluguel/{tickets}")
    public Set<DadosAluguel> getById(@PathVariable("tickets") Set<String> tickets) {
        //http://localhost:8080/dados-aluguel/bbas3,eztc3,pssa3,mdia3,bbdc3,itub3
        return leitorDadosAluguelService.executar(tickets);
    }

    @GetMapping("/")
    public String teste() {
        return "OK";
    }
}
