package com.mrv.monitor.scanner.webclient;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Setter
public class Resposta {
    @Getter
    private String name;

    private Collection<String[]> values;

    public Set<Detalhes> detalhes() {
        return values.stream().map(Detalhes::new).collect(Collectors.toSet());
    }

    @Getter
    public static class Detalhes {
        private static final int IDX_QUANTIDADE = 1;
        private static final int IDX_TAXA = 2;

        public final long quantidade;
        public final double taxa;

        private Detalhes(String[] dados) {
            this.quantidade = Long.parseLong(dados[IDX_QUANTIDADE]);
            this.taxa = Double.parseDouble(dados[IDX_TAXA]);
        }
    }
}
