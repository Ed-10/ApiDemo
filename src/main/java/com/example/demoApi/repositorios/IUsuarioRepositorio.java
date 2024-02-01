package com.example.demoApi.repositorios;

import com.example.demoApi.modelos.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<UsuarioModel, Integer> {
    public UsuarioModel findByCorreo(String correo); //Metodo para buscar por correo que este en sistema
}
