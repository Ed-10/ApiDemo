package com.example.demoApi.service;

import com.example.demoApi.modelos.ProductosModel;
import com.example.demoApi.modelos.UsuarioModel;
import com.example.demoApi.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class UsuarioService {
    //Inyeccion de nuestro repositorio PRODUCTOS
    @Autowired
    private IUsuarioRepositorio repositorio;
    //Metodo para GUARDAR en nuestra base de datos
    public void guardar(UsuarioModel entity){
        this.repositorio.save(entity);
    }
    //Metodo para buscar por correo
    public UsuarioModel buscarCorreo(String correo){
        return this.repositorio.findByCorreo(correo);
    }

}
