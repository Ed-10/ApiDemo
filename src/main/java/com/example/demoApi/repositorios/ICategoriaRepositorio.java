package com.example.demoApi.repositorios;

import com.example.demoApi.modelos.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepositorio extends JpaRepository<CategoriaModel, Integer> {
}
