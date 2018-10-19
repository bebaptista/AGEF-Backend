package com.tisv.agef.services;

import com.tisv.agef.domains.PecaFeira;
import com.tisv.agef.domains.Venda;
import com.tisv.agef.repositories.VendaRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository repo;

    private final PecaFeiraService pecaFeiraService;

    @Autowired
    public VendaService(VendaRepository repo, PecaFeiraService pecaFeiraService) {
        this.repo = repo;
        this.pecaFeiraService = pecaFeiraService;
    }

    public Venda find(Integer id) {
        Optional<Venda> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!" +
                        "\n" + "Parâmetro: " + id +
                        "\n" + "Tipo: " + Venda.class.getName()));
    }

    public List<Venda> findAll() {
        return repo.findAll();
    }

    public Venda insert(Venda venda) {
        PecaFeira pecaFeira = pecaFeiraService.find(venda.getPecaFeira().getId());

        Integer qtdEstoque = pecaFeira.getQuantidade();
        Integer qtdVendida = venda.getQuantidade();

        if (qtdVendida > qtdEstoque) {
            throw new IllegalArgumentException("A quantidade de produtos vendidos deve ser menor ou igual a quantidade de produtos em estoque");
        }

        Integer qtdAtualizadaEstoque = qtdEstoque - qtdVendida;
        pecaFeira.setQuantidade(qtdAtualizadaEstoque);
        pecaFeiraService.insert(pecaFeira);

        return repo.save(venda);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Double calcularFaturamento(LocalDate dataInicial, LocalDate dataFinal) {
        return repo.calcularFaturamento(dataInicial, dataFinal);
    }
}
