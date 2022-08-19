package com.mrv.monitor.scanner.webclient;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

public class B3WebClient {

    private final Logger logger = LoggerFactory.getLogger(B3WebClient.class);
    private final WebClient client;

    public B3WebClient() {
        var bufferSize = 16 * 1024 * 1024;

        var strategies = ExchangeStrategies
            .builder()
            .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(bufferSize))
            .build();

        client =
            WebClient
                .builder()
                .exchangeStrategies(strategies)
                .baseUrl("https://arquivos.b3.com.br/apinegocios/tickerbtb")
                .build();
    }

    public Resposta executar(String ticket, String data) {
        try {
            logger.debug("GET {}/{}", ticket, data);

            return client
                .get()
                .uri("/{ticket}/{data}", ticket.toUpperCase(), data)
                .retrieve()
                .bodyToMono(Resposta.class)
                .timeout(Duration.ofMillis(5000))
                .toFuture()
                .get();
        } catch (Exception e) {
            if (e.getCause() instanceof TimeoutException) {
                logger.error("Timeout - {}", ticket);
                return Resposta.empty(ticket + "(timeout)");
            }
            throw new RuntimeException(e);
        }
    }
}
