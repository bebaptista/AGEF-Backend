package com.tisv.agef.services;

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
        return repo.save(pecaFeira);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
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
