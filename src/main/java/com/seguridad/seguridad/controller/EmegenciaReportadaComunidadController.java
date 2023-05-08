
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.EmergenciaReportadaComunidad;
import com.seguridad.seguridad.services.EmergenciaReportadaComunidadService;
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
@RequestMapping({"emergencias/reportadas/comnidades"})
public class EmegenciaReportadaComunidadController {
    
    @Autowired
    private EmergenciaReportadaComunidadService service;
    
    @GetMapping
    public List<EmergenciaReportadaComunidad> listar(){
        return service.listarEmergenciasReportadasComunidades();
    }
    
    @PostMapping
    public EmergenciaReportadaComunidad insertar(@RequestBody EmergenciaReportadaComunidad emergenciaReportadaComunidad){
        return service.insertarEmergenciaReportadaComunidad(emergenciaReportadaComunidad);
    }
}
