package crudRest.repository;

import crudRest.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Miguel Castro
 */
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
    
}
