package com.mrv.monitor.scanner.common;

import java.util.Objects;
import java.util.function.Function;
import org.springframework.cache.Cache;

public class DadosCache {

    private final Cache cache;

    public DadosCache(Cache cache) {
        this.cache = Objects.requireNonNull(cache);
    }

    public DadosAluguel computeIfAbsent(String ticket, Function<String, DadosAluguel> computer) {
        var dados = cache.get(ticket, DadosAluguel.class);

        if (dados == null) {
            dados = computer.apply(ticket);
            cache.put(ticket, dados);
        }

        return dados;
    }
}
