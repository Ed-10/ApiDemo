package com.example.demoApi.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class ProductosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String slug;
    private String descripcion;
    private String precio;
    private String foto;
    @OneToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoriaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public CategoriaModel getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(CategoriaModel categoriaId) {
        this.categoriaId = categoriaId;
    }
}
