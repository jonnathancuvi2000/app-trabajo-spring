
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.Dispositivo;
import com.seguridad.seguridad.services.DispositivoService;
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
@RequestMapping({"dispositivos"})
public class DispositivoController {
    
    @Autowired
    private DispositivoService service;
    
     @GetMapping
    public List<Dispositivo> listar(){
        return service.listarDispositivos();
    }
    
    @PostMapping
    public Dispositivo insertar(@RequestBody Dispositivo dispositivo){
        return service.insertarDispositivo(dispositivo);
    }
    
}
