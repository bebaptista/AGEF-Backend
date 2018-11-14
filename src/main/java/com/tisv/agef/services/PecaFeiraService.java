package com.tisv.agef.services;

import com.tisv.agef.domains.Modelo;
import com.tisv.agef.domains.PecaFeira;
import com.tisv.agef.repositories.PecaFeiraRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PecaFeiraService {

    private final PecaFeiraRepository repo;

    @Autowired
    public PecaFeiraService(PecaFeiraRepository repo) {
        this.repo = repo;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public void estornar(Integer id, Integer qtdVendida) {
        this.repo.updateByIdSumQuantity(id, qtdVendida);
    }

    public PecaFeira find(Integer id) {
        Optional<PecaFeira> obj = repo.findByIdAndDeletadoIsFalse(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!" +
                        "\n" + "Parâmetro: " + id +
                        "\n" + "Tipo: " + PecaFeira.class.getName()));
    }

    public List<PecaFeira> findAll() {
        return repo.findAllByDeletadoIsFalse();
    }

    public PecaFeira insert(PecaFeira pecaFeira) {
        PecaFeira peca;
        Modelo modelo = pecaFeira.getModelo();
        Optional<PecaFeira> obj = repo.findByModeloAndDeletado(modelo, true);

        if (obj.isPresent()) {
            PecaFeira pecaDeletada = obj.get();

            Double novoPreco = pecaFeira.getPreco();
            Integer novaQuantidade = pecaFeira.getQuantidade();

            pecaDeletada.setDeletado(false);
            pecaDeletada.setPreco(novoPreco);
            pecaDeletada.setQuantidade(novaQuantidade);

            peca = pecaDeletada;

        } else {
            peca = pecaFeira;
        }

        return repo.save(peca);
    }

    public void update(Integer id, PecaFeira pecaFeiraArg) {
        Optional<PecaFeira> obj = repo.findById(id);

        if (obj.isPresent()) {
            PecaFeira pecaFeira = obj.get();

            pecaFeira.setPreco(pecaFeiraArg.getPreco());
            pecaFeira.setQuantidade(pecaFeiraArg.getQuantidade());

            repo.save(pecaFeira);
        }
    }

}
