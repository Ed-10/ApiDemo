package com.example.demoApi.repositorios;

import com.example.demoApi.modelos.ProductosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepositorio extends JpaRepository<ProductosModel,Integer> {
}
