package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.UsuarioVecinoAdmin;
import com.seguridad.seguridad.repository.UsuarioVecinoAdminRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioVecinoAdminServiceImp implements UsuarioVecinoAdminService {

    @Autowired
    private UsuarioVecinoAdminRepo repositorio;

    @Override
    public UsuarioVecinoAdmin insertarUsuario(UsuarioVecinoAdmin usuarioVecinoAdmin) {
        return repositorio.save(usuarioVecinoAdmin);
    }

    @Override
    public List<UsuarioVecinoAdmin> listarUsuarios() {
         return repositorio.findAll();
    }

    @Override
    public Optional<UsuarioVecinoAdmin> listarID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public UsuarioVecinoAdmin editar(UsuarioVecinoAdmin usuarioVecinoAdmin) {
        return repositorio.save(usuarioVecinoAdmin);
    }

    @Override
    public Optional<UsuarioVecinoAdmin> eliminar(int id) {
        Optional<UsuarioVecinoAdmin> usuarioVecinoAdmin = repositorio.findById(id);
        if(usuarioVecinoAdmin!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return usuarioVecinoAdmin;
    }

}
