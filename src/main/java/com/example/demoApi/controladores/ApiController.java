package com.example.demoApi.controladores;

import com.example.demoApi.modelos.EjemploModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @GetMapping("/metodo")//Este metodo GET es para listar todos nuestro registros
    public String metodo_get()
    {
        return "Metodo GET";
    }
    @GetMapping("/metodo/{id}")//Metodo GET que nos ayuda a mostrar un solo registro pos su ID
    public String metodo_get_parametro(@PathVariable("id") String id)
    {
        return "metodo GET con parametro = " + id;
    }

    @PostMapping("/metodo")
    public String metodo_post()
    {
        return "Metodo POST";
    }
    /*
    FORMATO QUE RECIBIMOS DE UN JSON

    "nombre":"Eduardo Martinez",
    "correo":"eduardo@gmail.com",
    "precio":123,
    "descripcion":"Esta es una descripcion"
     */
    @PostMapping("/metodo-json")
    public String metodo_json(@RequestBody EjemploModel ejemploModel)
    {
        return "Nombre: "+ejemploModel.getNombre() +
                "| Correo: "+ejemploModel.getCorreo()+
                " | Precio: "+ejemploModel.getPrecio()+
                " | Descripcion: "+ejemploModel.getDescripcion();
    }
    @PutMapping("/metodo")
    public String metodo_put()
    {
        return "Metodo PUT";
    }
    @DeleteMapping("/metodo")
    public String metodo_delete()
    {
        return"Metodo DELETE";
    }
}
