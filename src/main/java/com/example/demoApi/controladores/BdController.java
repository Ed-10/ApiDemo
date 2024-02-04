package com.example.demoApi.controladores;

import com.example.demoApi.modelos.CategoriaModel;
import com.example.demoApi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BdController {
    //CATEGORIAS
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/categorias")
    public List<CategoriaModel> categorias(){
        return this.categoriaService.Listar();
    }
    @GetMapping("/categorias/{id}")
    public CategoriaModel categoria_detalle(@PathVariable("id")Integer id){
        return this.categoriaService.buscarPorId(id);
    }
    //PRODCUTOS
}
