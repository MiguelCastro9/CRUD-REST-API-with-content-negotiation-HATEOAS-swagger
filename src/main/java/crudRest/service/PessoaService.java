package crudRest.service;

import crudRest.model.PessoaModel;
import crudRest.repository.PessoaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public PessoaModel inserir(PessoaModel pessoaModel) {

        return pessoaRepository.save(pessoaModel);
    }

    public PessoaModel alterar(Long id, PessoaModel pessoaModel) {

        PessoaModel pm = pessoaRepository.findById(id).get();
        pm.setNome(pessoaModel.getNome());
        pm.setEmail(pessoaModel.getEmail());

        return pessoaRepository.save(pm);
    }

    public List<PessoaModel> listar() {

        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> buscar(Long id) {

        return pessoaRepository.findById(id);
    }

    public void deletar(Long id) {

        pessoaRepository.deleteById(id);
    }
}
