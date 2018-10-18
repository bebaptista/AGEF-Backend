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

        Venda v1 = new Venda(100.00, 84, LocalDate.now(), p1.getModelo().getNome(), p1.getModelo().getTamanho());
        Venda v2 = new Venda(200.00, 74, LocalDate.now(), p2.getModelo().getNome(), p2.getModelo().getTamanho());
        Venda v3 = new Venda(300.00, 64, LocalDate.now(), p3.getModelo().getNome(), p3.getModelo().getTamanho());
        Venda v4 = new Venda(400.00, 54, LocalDate.now(), p4.getModelo().getNome(), p4.getModelo().getTamanho());
        Venda v5 = new Venda(500.00, 44, LocalDate.now(), p5.getModelo().getNome(), p5.getModelo().getTamanho());
        Venda v6 = new Venda(600.00, 34, LocalDate.now(), p6.getModelo().getNome(), p6.getModelo().getTamanho());
        Venda v7 = new Venda(700.00, 24, LocalDate.now(), p7.getModelo().getNome(), p7.getModelo().getTamanho());
        Venda v8 = new Venda(800.00, 14, LocalDate.now(), p8.getModelo().getNome(), p8.getModelo().getTamanho());
        Venda v9 = new Venda(900.00, 4, LocalDate.now(), p9.getModelo().getNome(), p9.getModelo().getTamanho());

        List<Venda> vendas = new ArrayList<>(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9));
        vendas.forEach(vendaService::insert);

        Defeito d1 = new Defeito(1, LocalDate.now(), p1.getModelo().getNome(), p1.getModelo().getTamanho());
        Defeito d2 = new Defeito(1, LocalDate.now(), p2.getModelo().getNome(), p2.getModelo().getTamanho());
        Defeito d3 = new Defeito(1, LocalDate.now(), p3.getModelo().getNome(), p3.getModelo().getTamanho());
        Defeito d4 = new Defeito(1, LocalDate.now(), p4.getModelo().getNome(), p4.getModelo().getTamanho());
        Defeito d5 = new Defeito(1, LocalDate.now(), p5.getModelo().getNome(), p5.getModelo().getTamanho());
        Defeito d6 = new Defeito(1, LocalDate.now(), p6.getModelo().getNome(), p6.getModelo().getTamanho());
        Defeito d7 = new Defeito(1, LocalDate.now(), p7.getModelo().getNome(), p7.getModelo().getTamanho());
        Defeito d8 = new Defeito(1, LocalDate.now(), p8.getModelo().getNome(), p8.getModelo().getTamanho());
        Defeito d9 = new Defeito(1, LocalDate.now(), p9.getModelo().getNome(), p9.getModelo().getTamanho());

        List<Defeito> defeitos = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
        defeitos.forEach(defeitoService::insert);
    }
}
