package com.tisv.agef;

import com.tisv.agef.domains.Defeito;
import com.tisv.agef.domains.Modelo;
import com.tisv.agef.domains.PecaFeira;
import com.tisv.agef.domains.Venda;
import com.tisv.agef.services.DefeitoService;
import com.tisv.agef.services.ModeloService;
import com.tisv.agef.services.PecaFeiraService;
import com.tisv.agef.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final ModeloService modeloService;

    private final PecaFeiraService pecaFeiraService;

    private final DefeitoService defeitoService;

    private final VendaService vendaService;

    @Autowired
    public Application(ModeloService modeloService, PecaFeiraService pecaFeiraService, DefeitoService defeitoService, VendaService vendaService) {
        this.modeloService = modeloService;
        this.pecaFeiraService = pecaFeiraService;
        this.defeitoService = defeitoService;
        this.vendaService = vendaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        Modelo m1 = new Modelo("Calça", "36");
        Modelo m2 = new Modelo("Calça", "37");
        Modelo m3 = new Modelo("Calça", "38");
        Modelo m4 = new Modelo("Camisa", "P");
        Modelo m5 = new Modelo("Camisa", "M");
        Modelo m6 = new Modelo("Camisa", "G");
        Modelo m7 = new Modelo("Moletom", "P");
        Modelo m8 = new Modelo("Moletom", "M");
        Modelo m9 = new Modelo("Moletom", "G");

        List<Modelo> modelos = new ArrayList<>(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9));
        modelos.forEach(modeloService::insert);

        PecaFeira p1 = new PecaFeira(100.00, 90, m1);
        PecaFeira p2 = new PecaFeira(200.00, 80, m2);
        PecaFeira p3 = new PecaFeira(300.00, 70, m3);
        PecaFeira p4 = new PecaFeira(400.00, 60, m4);
        PecaFeira p5 = new PecaFeira(500.00, 50, m5);
        PecaFeira p6 = new PecaFeira(600.00, 40, m6);
        PecaFeira p7 = new PecaFeira(700.00, 30, m7);
        PecaFeira p8 = new PecaFeira(800.00, 20, m8);
        PecaFeira p9 = new PecaFeira(900.00, 10, m9);

        List<PecaFeira> pecas = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
        pecas.forEach(pecaFeiraService::insert);

        Venda v1 = new Venda(100.00, 84, p1, LocalDate.now());
        Venda v2 = new Venda(200.00, 74, p2, LocalDate.now());
        Venda v3 = new Venda(300.00, 64, p3, LocalDate.now());
        Venda v4 = new Venda(400.00, 54, p4, LocalDate.now());
        Venda v5 = new Venda(500.00, 44, p5, LocalDate.now());
        Venda v6 = new Venda(600.00, 34, p6, LocalDate.now());
        Venda v7 = new Venda(700.00, 24, p7, LocalDate.now());
        Venda v8 = new Venda(800.00, 14, p8, LocalDate.now());
        Venda v9 = new Venda(900.00, 4, p9, LocalDate.now());

        List<Venda> vendas = new ArrayList<>(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9));
        vendas.forEach(vendaService::insert);

        Defeito d1 = new Defeito(p1, 1, LocalDate.now());
        Defeito d2 = new Defeito(p2, 1, LocalDate.now());
        Defeito d3 = new Defeito(p3, 1, LocalDate.now());
        Defeito d4 = new Defeito(p4, 1, LocalDate.now());
        Defeito d5 = new Defeito(p5, 1, LocalDate.now());
        Defeito d6 = new Defeito(p6, 1, LocalDate.now());
        Defeito d7 = new Defeito(p7, 1, LocalDate.now());
        Defeito d8 = new Defeito(p8, 1, LocalDate.now());
        Defeito d9 = new Defeito(p9, 1, LocalDate.now());

        List<Defeito> defeitos = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
        defeitos.forEach(defeitoService::insert);
    }
}
