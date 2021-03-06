package com.mrv.monitor.scanner.configuration;

import com.mrv.monitor.scanner.service.ExtratorDadosAluguelService;
import com.mrv.monitor.scanner.webclient.B3WebClient;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProvider {

    @Bean
    public B3WebClient webClient() {
        return new B3WebClient();
    }

    @Bean
    public ExtratorDadosAluguelService extrator() {
        return new ExtratorDadosAluguelService();
    }

    @Bean
    public DateTimeFormatter dateFormatter() {
        return DateTimeFormatter.ISO_DATE;
    }
}
