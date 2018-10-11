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

		Modelo m1 = new Modelo("Calca", "40");
		Modelo m2 = new Modelo("Blusa", "P");
		Modelo m3 = new Modelo("Jeans", "40");
		Modelo m4 = new Modelo("Carlos", "P");
		Modelo m5 = new Modelo("Eric", "40");
		Modelo m6 = new Modelo("Batata", "P");
		Modelo m7 = new Modelo("Meia", "40");
		Modelo m8 = new Modelo("Underwear", "P");
		Modelo m9 = new Modelo("Meia calca", "40");
		Modelo m10 = new Modelo("Sem ideia", "P");

		modeloRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10));

		PecaFeira pf1 = new PecaFeira(m1, 40.00, 100);
		PecaFeira pf2 = new PecaFeira(m2, 50.00, 90);
		PecaFeira pf3 = new PecaFeira(m3, 60.00, 80);
		PecaFeira pf4 = new PecaFeira(m4, 70.00, 70);
		PecaFeira pf5 = new PecaFeira(m5, 80.00, 60);
		PecaFeira pf6 = new PecaFeira(m6, 90.00, 50);
		PecaFeira pf7 = new PecaFeira(m7, 100.00, 40);
		PecaFeira pf8 = new PecaFeira(m8, 110.00, 30);
		PecaFeira pf9 = new PecaFeira(m9, 120.00, 20);
		PecaFeira pf10 = new PecaFeira(m10, 130.00, 10);

		pecaFeiraRepository.saveAll(Arrays.asList(pf1, pf2, pf3, pf4, pf5, pf6, pf7, pf8, pf9, pf10));

		Venda v1 = new Venda(10.00, pf1.getNome(), pf1.getTamanho(), 30, LocalDate.now());
		Venda v2 = new Venda(20.00, pf2.getNome(), pf2.getTamanho(), 40, LocalDate.now());
		Venda v3 = new Venda(30.00, pf3.getNome(), pf3.getTamanho(), 50, LocalDate.now());
		Venda v4 = new Venda(40.00, pf4.getNome(), pf4.getTamanho(), 60, LocalDate.now());
		Venda v5 = new Venda(50.00, pf5.getNome(), pf5.getTamanho(), 70, LocalDate.now());
		Venda v6 = new Venda(60.00, pf6.getNome(), pf6.getTamanho(), 80, LocalDate.now());
		Venda v7 = new Venda(70.00, pf7.getNome(), pf7.getTamanho(), 90, LocalDate.now());
		Venda v8 = new Venda(80.00, pf8.getNome(), pf8.getTamanho(), 100, LocalDate.now());
		Venda v9 = new Venda(90.00, pf9.getNome(), pf9.getTamanho(), 110, LocalDate.now());
		Venda v10 = new Venda(100.00, pf10.getNome(), pf10.getTamanho(), 120, LocalDate.now());

		vendaRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10));

		Defeito d1 = new Defeito(pf1.getNome(), pf1.getTamanho(), 1, LocalDate.now());
		Defeito d2 = new Defeito(pf2.getNome(), pf2.getTamanho(), 1, LocalDate.now());
		Defeito d3 = new Defeito(pf3.getNome(), pf3.getTamanho(), 1, LocalDate.now());
		Defeito d4 = new Defeito(pf4.getNome(), pf4.getTamanho(), 1, LocalDate.now());
		Defeito d5 = new Defeito(pf5.getNome(), pf5.getTamanho(), 1, LocalDate.now());
		Defeito d6 = new Defeito(pf6.getNome(), pf6.getTamanho(), 1, LocalDate.now());
		Defeito d7 = new Defeito(pf7.getNome(), pf7.getTamanho(), 1, LocalDate.now());
		Defeito d8 = new Defeito(pf8.getNome(), pf8.getTamanho(), 1, LocalDate.now());
		Defeito d9 = new Defeito(pf9.getNome(), pf9.getTamanho(), 1, LocalDate.now());
		Defeito d10 = new Defeito(pf10.getNome(), pf10.getTamanho(), 1, LocalDate.now());

		defeitoRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10));
	}
}
