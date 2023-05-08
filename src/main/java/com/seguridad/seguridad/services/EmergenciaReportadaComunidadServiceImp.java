package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.EmergenciaReportadaComunidad;
import com.seguridad.seguridad.repository.EmergenciaReportadaComunidadRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergenciaReportadaComunidadServiceImp implements EmergenciaReportadaComunidadService {

    @Autowired
    private EmergenciaReportadaComunidadRepo repositorio;

    @Override
    public EmergenciaReportadaComunidad insertarEmergenciaReportadaComunidad(EmergenciaReportadaComunidad emergenciaReportadaComunidad) {
        return repositorio.save(emergenciaReportadaComunidad);
    }

    @Override
    public List<EmergenciaReportadaComunidad> listarEmergenciasReportadasComunidades() {
        return repositorio.findAll();
    }

    @Override
    public Optional<EmergenciaReportadaComunidad> listarEmergenciasReportadasComunidadesID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public EmergenciaReportadaComunidad editarEmergenciaReportadaComunidad(EmergenciaReportadaComunidad emergenciaReportadaComunidad) {
        return repositorio.save(emergenciaReportadaComunidad);
    }

    @Override
    public Optional<EmergenciaReportadaComunidad> eliminarEmergenciaReportadaComunidad(int id) {
        Optional<EmergenciaReportadaComunidad> emergenciaReportadaComunidad = repositorio.findById(id);
        if (emergenciaReportadaComunidad != null) {//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return emergenciaReportadaComunidad;
    }
}
