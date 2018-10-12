package com.tisv.agef.services;

import com.tisv.agef.domain.Defeito;
import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.repositories.DefeitoRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefeitoService {

    private final DefeitoRepository repo;

    private final PecaFeiraService pecaFeiraService;

    @Autowired
    public DefeitoService(DefeitoRepository repo, PecaFeiraService pecaFeiraService) {
        this.repo = repo;
        this.pecaFeiraService = pecaFeiraService;
    }

    public Defeito find(Integer id) {
        Optional<Defeito> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!" +
                        "\n" + "Parâmetro: '" + id + "'." +
                        "\n" + "Tipo: '" + Defeito.class.getName() + "'."));
    }

    public List<Defeito> findAll() {
        return repo.findAll();
    }

    public Defeito insert(Defeito defeito) {
        String nome = defeito.getNome();
        String tamanho = defeito.getTamanho();
        PecaFeira pecaFeira = pecaFeiraService.findByModeloNomeAndModeloTamanho(nome, tamanho);

        Integer qtdEstoque = pecaFeira.getQuantidade();
        Integer qtdVendida = defeito.getQuantidade();

        if (qtdVendida > qtdEstoque) {
            throw new IllegalArgumentException("A quantidade de produtos defeituosos deve ser menor ou igual a quantidade de produtos em estoque");
        }

        Integer qtdAtualizadaEstoque = qtdEstoque - qtdVendida;
        pecaFeira.setQuantidade(qtdAtualizadaEstoque);
        pecaFeiraService.insert(pecaFeira);

        return repo.save(defeito);
    }


    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
