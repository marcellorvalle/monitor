package com.mrv.monitor.scanner.webclient;

import java.util.Optional;
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

    public Optional<Resposta> executar(String ticket, String data) {
        try {
            logger.debug("Baixando dados para {} em {}", ticket, data);

            return Optional.ofNullable(
                client
                    .get()
                    .uri("/{ticket}/{data}", ticket, data)
                    .retrieve()
                    .bodyToMono(Resposta.class)
                    .toFuture()
                    .get()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
