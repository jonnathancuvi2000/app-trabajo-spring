
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.EmergenciaReportadaDao;
import com.seguridad.seguridad.entities.EmergenciaReportada;
import com.seguridad.seguridad.services.EmergenciaReportadaService;
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
@RequestMapping({"emergencias/reportadas"})
public class EmergenciaReportadaController {
    
    @Autowired
    private EmergenciaReportadaService service;
    
    @Autowired
    private EmergenciaReportadaDao emergenciaReportadadDao;
    
    @GetMapping({"/ultimoelemento"})
    public EmergenciaReportada getLastElement(){
        return emergenciaReportadadDao.obtenerUltimaEmergenciaReportada();
    }
    
    @GetMapping
    public List<EmergenciaReportada> listar(){
        return service.listarEmergenciasReportadas();
    }
    
     @PostMapping
    public EmergenciaReportada insertar(@RequestBody EmergenciaReportada emergencia){
        return service.insertarEmergenciaReportada(emergencia);
    }
    
}
