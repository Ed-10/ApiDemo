package com.example.demoApi.service;

import com.example.demoApi.modelos.ProductosModel;
import com.example.demoApi.repositorios.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductosService {
    //Inyeccion de nuestro repositorio PRODUCTOS
    @Autowired
    private IProductoRepositorio repositorio;
    //Metodo para LISTAR en orden decendente
    public List<ProductosModel> Listar(){
        return this.repositorio.findAll(Sort.by("id").descending());
    }
    //Metodo para GUARDAR en nuestra base de datos
    public void guardar(ProductosModel producto){
        this.repositorio.save(producto);
    }
    //Metodo para BUSCAR por ID
    public ProductosModel buscarPorId(Integer id){
        Optional<ProductosModel> optional = repositorio.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    //Metodo para ELIMINAR algun producto
    public void eliminar (Integer id){
        this.repositorio.deleteById(id);
    }
}
