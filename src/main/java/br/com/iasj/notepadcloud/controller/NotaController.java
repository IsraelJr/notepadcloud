package br.com.iasj.notepadcloud.controller;

import br.com.iasj.notepadcloud.componente.NotaComponent;
import br.com.iasj.notepadcloud.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping(value = "nota")
public class NotaController {

    @Autowired
    private NotaComponent notaComponent;

    @GetMapping("/titulo/{titulo}")
    public Nota buscarNota(@PathVariable(value = "titulo") String titulo){
        return notaComponent.buscatNota(titulo);
    }

    @GetMapping()
    public List<Nota> buscarTodos(){
        return  notaComponent.findAll();
    }

    @DeleteMapping("/titulo/{titulo}")
    public void apagar(@PathVariable(value = "titulo") String titulo){
        notaComponent.deleteAll();
    }

    @PostMapping
    public void salvar(@RequestBody Nota nota){
        notaComponent.salvar(nota);
    }

}
