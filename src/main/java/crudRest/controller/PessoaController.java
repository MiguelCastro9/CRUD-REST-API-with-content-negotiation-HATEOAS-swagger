package crudRest.controller;

import crudRest.model.PessoaModel;
import crudRest.service.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping(value = "/insere", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PessoaModel insere(@RequestBody PessoaModel pessoaModel) {

        PessoaModel p = pessoaService.inserir(pessoaModel);
        pessoaModel.add(linkTo(methodOn(PessoaController.class).insere(p)).withSelfRel());
        return pessoaModel;
    }

    @PutMapping(value = "/altera/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PessoaModel altera(@PathVariable("id") Long id, @RequestBody PessoaModel pessoaModel) {

        PessoaModel p = pessoaService.inserir(pessoaModel);
        pessoaModel.add(linkTo(methodOn(PessoaController.class).busca(p.getId())).withSelfRel());
        return pessoaModel;
    }
    
    @GetMapping(value = "/lista", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PessoaModel> lista() {

        List<PessoaModel> ps = pessoaService.listar();
        ps.stream().forEach(p -> p.add(linkTo(methodOn(PessoaController.class).busca(p.getId())).withSelfRel()));
        return ps;
    }

    @GetMapping(value = "/busca/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PessoaModel busca(@PathVariable("id") Long id) {

        PessoaModel pessoaModel = pessoaService.buscar(id).orElseThrow();
        pessoaModel.add(linkTo(methodOn(PessoaController.class).busca(id)).withSelfRel());
        return pessoaModel;
    }

    @DeleteMapping("/deleta/{id}")
    public void deleta(@PathVariable("id") Long id) {

        pessoaService.deletar(id);
    }
}
