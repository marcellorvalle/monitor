package com.mrv.monitor.scanner.webclient;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public record Resposta(String name, Collection<String[]> values) {
    public static Resposta empty(String name) {
        return new Resposta(name, Collections.emptyList());
    }
    public Set<Detalhe> detalhes() {
        return values.stream().map(Detalhe::new).collect(Collectors.toSet());
    }

    public record Detalhe(long quantidade, double taxa) {
        private static final int IDX_QUANTIDADE = 1;
        private static final int IDX_VALOR = 2;
        private Detalhe(String[] value) {
            this(Long.parseLong(value[IDX_QUANTIDADE]), Double.parseDouble(value[IDX_VALOR]));
        }
    }
}
