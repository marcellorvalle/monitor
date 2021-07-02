package com.mrv.monitor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonitorApplication  implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("RODANDO!");
	}
}
