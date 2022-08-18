package com.mrv.monitor.scanner.configuration;

import com.mrv.monitor.scanner.common.DadosCache;
import com.mrv.monitor.scanner.webclient.B3WebClient;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProvider {

    @Bean
    public B3WebClient webClient() {
        return new B3WebClient();
    }

    @Bean(name = "meh")
    public DadosCache caches(CacheManager cacheManager) {
        return new DadosCache(cacheManager.getCache("dadosAluguel"));
    }
}
