
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.Comunidad;
import com.seguridad.seguridad.services.ComunidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"comunidades"})
public class ComunidadController {
    
    @Autowired
    private ComunidadService service;
    
    @GetMapping
    public List<Comunidad> listar(){
        return service.listarComunidades();
    }
    
    @PostMapping
    public Comunidad insertar(@RequestBody Comunidad comunidad){
        return service.insertarComuidad(comunidad);
    }
}
