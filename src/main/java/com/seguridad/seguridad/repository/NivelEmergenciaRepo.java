/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.seguridad.seguridad.repository;

import com.seguridad.seguridad.entities.NivelEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Admin
 */
public interface NivelEmergenciaRepo extends JpaRepository<NivelEmergencia, Integer>{
    
}
