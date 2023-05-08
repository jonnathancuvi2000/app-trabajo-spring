
package com.seguridad.seguridad.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emergencia_reportada_comunidad")
public class EmergenciaReportadaComunidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emergenciaReportadaComunidad_id;
    private String codigo;
    private boolean estadoEmergencia;
    private Date fechaCreacion;
    private Date FechaModificacion;

//    RELACION COMUNIDAD
    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;

    public int getEmergenciaReportadaComunidad_id() {
        return emergenciaReportadaComunidad_id;
    }

    public void setEmergenciaReportadaComunidad_id(int emergenciaReportadaComunidad_id) {
        this.emergenciaReportadaComunidad_id = emergenciaReportadaComunidad_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isEstadoEmergencia() {
        return estadoEmergencia;
    }

    public void setEstadoEmergencia(boolean estadoEmergencia) {
        this.estadoEmergencia = estadoEmergencia;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return FechaModificacion;
    }

    public void setFechaModificacion(Date FechaModificacion) {
        this.FechaModificacion = FechaModificacion;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }
    
    

    
    
    
    
}
