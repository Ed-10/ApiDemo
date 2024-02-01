package com.example.demoApi.controladores;

import com.example.demoApi.modelos.EjemploModel;
import com.example.demoApi.utilidades.Utilidades;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ResponseEntityController {
    @GetMapping("/response-entity")
    public ResponseEntity<String> metodo_get(){
        return ResponseEntity.ok("metodo Get OK desde ResponseEntityController");
    }
    @GetMapping("/response-entity/{id}")
    public ResponseEntity<String> metodo_get_parametro(@PathVariable("id") String id){
        return ResponseEntity.ok("metodo GET ok " + id + " desde ResponseEntityController");
    }
    @GetMapping("/response-entity-personalizado")
    public ResponseEntity<Object> metodo_get_personalizado(){
        return Utilidades.generadorResponse(HttpStatus.OK,"Mi ResponseEntity personalizado");
    }
    @PostMapping("/response-entity")
    public ResponseEntity<String> metodo_post(){
        return ResponseEntity.ok("metodo POST OK desde ResponseEntityController");
    }
    /*
    FORMATO QUE RECIBIMOS DE UN JSON

    "nombre":"Eduardo Martinez",
    "correo":"eduardo@gmail.com",
    "precio":123,
    "descripcion":"Esta es una descripcion"
    */
    @PostMapping("/metodo-json-response")
    public ResponseEntity<String> metodo_json_response(@RequestBody EjemploModel ejemploModel){
        return ResponseEntity.ok(
                "Nombre: "+ejemploModel.getNombre() +
                "| Correo: "+ejemploModel.getCorreo()+
                " | Precio: "+ejemploModel.getPrecio()+
                " | Descripcion: "+ejemploModel.getDescripcion());
    }
    @PutMapping("/response-entity")
    public ResponseEntity<String> metodo_put(){
        return ResponseEntity.ok("metodo PUT OK desde ResponseEntityController");
    }
    @DeleteMapping("/response-entity")
    public ResponseEntity<String> metodo_delete(){
        return ResponseEntity.ok("metodo DELETE OK desde ResponseEntityController");
    }
}
