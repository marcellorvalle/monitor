package com.mrv.monitor.scanner.service;

import com.mrv.monitor.scanner.webclient.Resposta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

class ExtratorDadosAluguelServiceTest {

    @Test
    void deve() {
        //https://arquivos.b3.com.br/apinegocios/tickerbtb/B3SA3/2021-07-02

        var client = WebClient.builder().baseUrl("https://arquivos.b3.com.br/apinegocios/tickerbtb").build();

        var result = client
            .get()
            .uri("/{ticket}/{data}", "ITUB3", "2021-07-02")
            .retrieve()
            .bodyToMono(Resposta.class)
            .block();

        var dados = new ExtratorDadosAluguelService().executar(result);

        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
