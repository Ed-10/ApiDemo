package com.example.demoApi.controladores;

import com.example.demoApi.modelos.CategoriaModel;
import com.example.demoApi.modelos.ProductosModel;
import com.example.demoApi.service.CategoriaService;
import com.example.demoApi.service.ProductosService;
import com.example.demoApi.utilidades.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //Metodo para la creacion de registros
    @PostMapping("/categorias")
    //Metodo de tipo transaccionarl
    public ResponseEntity <Object> categorias_post(@RequestBody CategoriaModel request){
        request.setSlug(Utilidades.getSlug(request.getNombre()));
        this.categoriaService.guardar(request);
        return Utilidades.generadorResponse(HttpStatus.CREATED,"Se creo el registro");
    }
    @PutMapping("/categorias/{id}")
    public ResponseEntity<Object> categorias_put(@PathVariable("id")Integer id,
                                                 @RequestBody CategoriaModel request){
        CategoriaModel categoria = this.categoriaService.buscarPorId(id);
        categoria.setNombre(request.getNombre());
        categoria.setSlug(Utilidades.getSlug(request.getNombre()));

        this.categoriaService.guardar(categoria);
        return Utilidades.generadorResponse(HttpStatus.OK,"Se edito el registro de forma exitosa");
    }
    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Object> categorias_delite(@PathVariable("id")Integer id){
        try {
        this.categoriaService.eliminar(id);
        return Utilidades.generadorResponse(HttpStatus.OK,"Se ah eliminado de forma correcta");
        }catch (Exception e){
            return Utilidades.generadorResponse(HttpStatus.BAD_REQUEST,"Fallo la ejecucion, intentelo mas tarde");
        }

    }
    //PRODCUTOS
    @Autowired
    private ProductosService productosService;
    //Listando nuestros productos
    @GetMapping("/productos")
    public List<ProductosModel> productos(){
        return this.productosService.Listar();
    }
    @GetMapping("/productos/{id}")
    public ProductosModel producto_detalle(@PathVariable("id")Integer id){
        return this.productosService.buscarPorId(id);
    }
}
