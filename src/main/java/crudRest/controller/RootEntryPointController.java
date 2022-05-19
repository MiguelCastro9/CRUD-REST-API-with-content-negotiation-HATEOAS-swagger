package crudRest.controller;

import crudRest.model.RootEntryPointModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
public class RootEntryPointController {
    
    @GetMapping
    public RootEntryPointModel root() {
        
        var model = new RootEntryPointModel();
        model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class).lista()).withRel("lista de pessoas"));
        return model;
    }
}
