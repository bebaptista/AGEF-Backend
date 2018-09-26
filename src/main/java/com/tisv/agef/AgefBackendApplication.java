package com.tisv.agef;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.repositories.PecaFeiraRepository;
import com.tisv.agef.repositories.PecaRepository;

@SpringBootApplication
public class AgefBackendApplication implements CommandLineRunner {

	@Autowired
	private PecaRepository pecaRepository;

	@Autowired
	private PecaFeiraRepository pecaFeiraRepository;
	
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

		PecaFeira pf1 = new PecaFeira(p1, 40.00, 100);
		PecaFeira pf2 = new PecaFeira(p2, 50.00, 90);	
		PecaFeira pf3 = new PecaFeira(p3, 60.00, 80);	
		PecaFeira pf4 = new PecaFeira(p4, 70.00, 70);	
		PecaFeira pf5 = new PecaFeira(p5, 80.00, 60);	
		PecaFeira pf6 = new PecaFeira(p6, 90.00, 50);	
		PecaFeira pf7 = new PecaFeira(p7, 100.00, 40);	
		PecaFeira pf8 = new PecaFeira(p8, 110.00, 30);	
		PecaFeira pf9 = new PecaFeira(p9, 120.00, 20);	
		PecaFeira pf10 = new PecaFeira(p10, 130.00, 10);	
		
		pecaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

		pecaFeiraRepository.saveAll(Arrays.asList(pf1, pf2, pf3, pf4, pf5, pf6, pf7, pf8, pf9, pf10));
	}
}
