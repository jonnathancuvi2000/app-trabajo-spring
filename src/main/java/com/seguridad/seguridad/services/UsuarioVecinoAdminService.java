package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.UsuarioVecinoAdmin;
import java.util.List;
import java.util.Optional;

public interface UsuarioVecinoAdminService {

    UsuarioVecinoAdmin insertarUsuario(UsuarioVecinoAdmin usuarioVecinoAdmin);

    List<UsuarioVecinoAdmin> listarUsuarios();

    Optional<UsuarioVecinoAdmin> listarID(int id);

    UsuarioVecinoAdmin editar(UsuarioVecinoAdmin usuarioVecinoAdmin);

    Optional<UsuarioVecinoAdmin> eliminar(int id);

}
