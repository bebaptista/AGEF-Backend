package com.tisv.agef.services;

import com.tisv.agef.domains.Defeito;
import com.tisv.agef.domains.PecaFeira;
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
                        "\n" + "Parâmetro: " + id +
                        "\n" + "Tipo: " + Defeito.class.getName()));
    }

    public List<Defeito> findAll() {
        return repo.findAll();
    }

    public Defeito insert(Defeito defeito) {
        PecaFeira pecaFeira = pecaFeiraService.find(defeito.getPecaFeira().getId());

        Integer qtdEstoque = pecaFeira.getQuantidade();
        Integer qtdDefeituosa = defeito.getQuantidade();

        if (qtdDefeituosa > qtdEstoque) {
            throw new IllegalArgumentException("A quantidade de produtos defeituosos deve ser menor ou igual a quantidade de produtos em estoque");
        }

        Integer qtdAtualizadaEstoque = qtdEstoque - qtdDefeituosa;
        pecaFeira.setQuantidade(qtdAtualizadaEstoque);
        pecaFeiraService.insert(pecaFeira);

        return repo.save(defeito);
    }


    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
