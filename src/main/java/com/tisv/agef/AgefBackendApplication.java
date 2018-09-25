package com.tisv.agef;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.repositories.PecaRepository;

@SpringBootApplication
public class AgefBackendApplication implements CommandLineRunner {

	@Autowired
	private PecaRepository pecaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgefBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Peca p1 = new Peca("Calca", 40);
		Peca p2 = new Peca("Blusa", 30);

		pecaRepository.saveAll(Arrays.asList(p1, p2));

	}
}
