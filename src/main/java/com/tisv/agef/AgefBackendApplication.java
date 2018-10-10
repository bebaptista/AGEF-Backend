package com.tisv.agef;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tisv.agef.domain.Defeito;
import com.tisv.agef.domain.Modelo;
import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.domain.Venda;
import com.tisv.agef.repositories.DefeitoRepository;
import com.tisv.agef.repositories.ModeloRepository;
import com.tisv.agef.repositories.PecaFeiraRepository;
import com.tisv.agef.repositories.VendaRepository;

@SpringBootApplication
public class AgefBackendApplication implements CommandLineRunner {

	@Autowired
	private ModeloRepository modeloRepository;

	@Autowired
	private PecaFeiraRepository pecaFeiraRepository;
	
	@Autowired
	private DefeitoRepository defeitoRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgefBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Modelo p1 = new Modelo("Calca", "40");
		Modelo p2 = new Modelo("Blusa", "P");
		Modelo p3 = new Modelo("Jeans", "40");
		Modelo p4 = new Modelo("Carlos", "P");
		Modelo p5 = new Modelo("Eric", "40");
		Modelo p6 = new Modelo("Batata", "P");
		Modelo p7 = new Modelo("Meia", "40");
		Modelo p8 = new Modelo("Underwear", "P");
		Modelo p9 = new Modelo("Meia calca", "40");
		Modelo p10 = new Modelo("Sem ideia", "P");

		modeloRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
		
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
		
		pecaFeiraRepository.saveAll(Arrays.asList(pf1, pf2, pf3, pf4, pf5, pf6, pf7, pf8, pf9, pf10));
		
		Venda v1 = new Venda(10.00, p1.getNome(), p1.getTamanho(), 30, LocalDate.now());
		Venda v2 = new Venda(20.00, p2.getNome(), p2.getTamanho(), 40, LocalDate.now());	
		Venda v3 = new Venda(30.00, p3.getNome(), p3.getTamanho(), 50, LocalDate.now());	
		Venda v4 = new Venda(40.00, p4.getNome(), p4.getTamanho(), 60, LocalDate.now());	
		Venda v5 = new Venda(50.00, p5.getNome(), p5.getTamanho(), 70, LocalDate.now());	
		Venda v6 = new Venda(60.00, p6.getNome(), p6.getTamanho(), 80, LocalDate.now());	
		Venda v7 = new Venda(70.00, p7.getNome(), p7.getTamanho(), 90, LocalDate.now());	
		Venda v8 = new Venda(80.00, p8.getNome(), p8.getTamanho(), 100, LocalDate.now());	
		Venda v9 = new Venda(90.00, p9.getNome(), p9.getTamanho(), 110, LocalDate.now());	
		Venda v10 = new Venda(100.00, p10.getNome(), p10.getTamanho(), 120, LocalDate.now());	
		
		vendaRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10));
		
		Defeito d1 = new Defeito(pf1,LocalDate.now(),1);
		Defeito d2 = new Defeito(pf1,LocalDate.now(),1);
		Defeito d3 = new Defeito(pf1,LocalDate.now(),1);
		Defeito d4 = new Defeito(pf1,LocalDate.now(),1);
		Defeito d5 = new Defeito(pf1,LocalDate.now(),1);
		Defeito d6 = new Defeito(pf1,LocalDate.now(),1);
		Defeito d7 = new Defeito(pf1,LocalDate.now(),1);
		Defeito d8 = new Defeito(pf1,LocalDate.now(),1);
		Defeito d9 = new Defeito(pf1,LocalDate.now(),1);
		Defeito d10 = new Defeito(pf1,LocalDate.now(),1);
		
		defeitoRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10));
	}
}
