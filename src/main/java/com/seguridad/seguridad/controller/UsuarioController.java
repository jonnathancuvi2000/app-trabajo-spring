
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.UsuarioDao;
import com.seguridad.seguridad.entities.Usuarios;
import com.seguridad.seguridad.services.UsuarioService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//como agreglar el problema de cros: https://www.youtube.com/watch?v=ZkSO_wW2Wuw
@CrossOrigin
@RestController
@RequestMapping({"usuarios"})
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
     @Autowired
    private UsuarioDao usuarioDao;
    
    @GetMapping
    public List<Usuarios> listar(){
        return service.listarUsuarios();
    }
    
    @PostMapping
    public Usuarios insertar(@RequestBody Usuarios usuarrio){
//        ENCRIPTAMOS LA CONTRASENA
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuarrio.getContrasena());
//        GUARDAMOS LA CONTRASENA ENCRIPTADA
        usuarrio.setContrasena(hash);
        
        return service.insertarUsuario(usuarrio);
    }
    
     @GetMapping(path = {"/{id}"})
    public Optional<Usuarios> listarIdRespuestasIndicadorId(@PathVariable("id") int id) {
        return service.listarID(id);
    }
    
    @GetMapping(path = {"/comunidadusers/{id}"})
    public List<Usuarios> listarUsuariosComunidad(@PathVariable("id") int id) {
        return usuarioDao.obtenerUsuariosComunidad(id);
    }
  
    @PutMapping(path = {"/{id}"})
    public Usuarios editarEstandar(@RequestBody Usuarios usuario, @PathVariable("id") int id) {
        usuario.setUsuario_id(id);
        return service.editar(usuario);
    }
    
//     @PutMapping(path = {"/actualizarEstandar/{id}"})//https://www.youtube.com/watch?v=-nzB6HIiGqQ
//    public Estandar editarEstandar(@RequestBody Estandar p, @PathVariable("id") int id) {
//        p.setEstandar_ID(id);
//        return serivceEstandar.editar(p);
//    }
//
//    @DeleteMapping(path = {"/eliminarEstandar/{id}"})
//    public Optional<Estandar> eliminarEstandar(@PathVariable("id") int id) {
//        return serivceEstandar.eliminar(id);
//    }
    
}
