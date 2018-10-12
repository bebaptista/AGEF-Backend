package com.tisv.agef.services;

import com.tisv.agef.domain.Modelo;
import com.tisv.agef.repositories.ModeloRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    private final ModeloRepository repo;

    @Autowired
    public ModeloService(ModeloRepository repo) {
        this.repo = repo;
    }

    public Modelo find(Integer id) {
        Optional<Modelo> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!" +
                        "\n" + "Parâmetro: '" + id + "'." +
                        "\n" + "Tipo: '" + Modelo.class.getName() + "'."));
    }

    public List<Modelo> findAll() {
        return repo.findAll();
    }

    public Modelo insert(Modelo modelo) {
        return repo.save(modelo);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public void update(Integer id, Modelo modeloArg) {
        Optional<Modelo> obj = repo.findById(id);

        if (obj.isPresent()) {
            Modelo modelo = obj.get();

            modelo.setNome(modeloArg.getNome());
            modelo.setTamanho(modeloArg.getTamanho());

            repo.save(modelo);
        }
    }
}
