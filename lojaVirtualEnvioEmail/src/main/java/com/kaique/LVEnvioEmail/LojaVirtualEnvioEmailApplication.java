package com.kaique.LVEnvioEmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class LojaVirtualEnvioEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualEnvioEmailApplication.class, args);
	}

}
