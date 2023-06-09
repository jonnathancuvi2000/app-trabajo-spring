
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.Emergencia;
import com.seguridad.seguridad.services.EmergenciaService;
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
@RequestMapping({"emergencias"})
public class EmergenciaController {
    
    @Autowired
    private EmergenciaService service;
    
    @GetMapping
    public List<Emergencia> listar(){
        return service.listarEmergencias();
    }
    
     @PostMapping
    public Emergencia insertar(@RequestBody Emergencia emergencia){
        return service.insertarEmergencia(emergencia);
    }
    
}
