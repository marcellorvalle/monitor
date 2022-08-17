package com.mrv.monitor.scanner.webclient;

import org.springframework.web.reactive.function.client.WebClient;

public class B3WebClient {

    private final WebClient client;

    public B3WebClient() {
        client = WebClient.create("https://arquivos.b3.com.br/apinegocios/tickerbtb");
    }

    public Resposta executar(String ticket, String data) {
        return client.get().uri("/{ticket}/{data}", ticket, data).retrieve().bodyToMono(Resposta.class).block();
    }
}
