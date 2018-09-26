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

		Peca p1 = new Peca("Calca", "40");
		Peca p2 = new Peca("Blusa", "P");
		Peca p3 = new Peca("Jeans", "40");
		Peca p4 = new Peca("Carlos", "P");
		Peca p5 = new Peca("Eric", "40");
		Peca p6 = new Peca("Batata", "P");
		Peca p7 = new Peca("Meia", "40");
		Peca p8 = new Peca("Underwear", "P");
		Peca p9 = new Peca("Meia calca", "40");
		Peca p10 = new Peca("Sem ideia", "P");

		pecaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

	}
}
