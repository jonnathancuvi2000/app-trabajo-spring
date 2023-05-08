
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.EmergenciaReportadaComunidad;
import java.util.List;
import java.util.Optional;

public interface EmergenciaReportadaComunidadService {
    
    EmergenciaReportadaComunidad insertarEmergenciaReportadaComunidad(EmergenciaReportadaComunidad emergenciaReportadaComunidad);

    List<EmergenciaReportadaComunidad> listarEmergenciasReportadasComunidades();

    Optional<EmergenciaReportadaComunidad> listarEmergenciasReportadasComunidadesID(int id);

    EmergenciaReportadaComunidad editarEmergenciaReportadaComunidad(EmergenciaReportadaComunidad emergenciaReportadaComunidad);

    Optional<EmergenciaReportadaComunidad> eliminarEmergenciaReportadaComunidad(int id);
    
}
