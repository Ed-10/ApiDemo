package com.example.demoApi.service;

import com.example.demoApi.modelos.CategoriaModel;
import com.example.demoApi.repositorios.ICategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//Creacion se servicio para conexcion a la base de datos
@Service
@Primary
public class CategoriaService {
    //Inyeccion de nuestro repositorio CATEGORIA
    @Autowired
    private ICategoriaRepositorio repositorio;
    //Metodo para LISTAR en orden decendente
    public List<CategoriaModel> Listar(){
        return this.repositorio.findAll(Sort.by("id").descending());
    }
    //Metodo para GUARDAR en nuestra base de datos
    public void guardar(CategoriaModel categoria){
        this.repositorio.save(categoria);
    }
    //Metodo para BUSCAR por ID
    public CategoriaModel buscarPorId(Integer id){
        Optional<CategoriaModel> optional = repositorio.findById(id);
        if (optional.isPresent()){
            optional.get();
        }
        return null;
    }
    //Metodo para ELIMINAR alguna categoria
    public void eliminar (Integer id){
        this.repositorio.deleteById(id);
    }
}
