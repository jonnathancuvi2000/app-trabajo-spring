package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.Usuarios;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Usuarios obtenerUsuarioPorCredenciales(Usuarios usuario) {

        System.out.println(usuario.getCorreo_1());
        boolean valor = false;
        String query = "select u from Usuarios as u where u.correo_1 = :correo";
        List<Usuarios> lista = entityManager.createQuery(query).setParameter("correo", usuario.getCorreo_1()).getResultList();
//        SI LA LISTA ESTA VACIA NO SE ENCONTRO UN USUARIO CON EL CORREO
        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getContrasena();
//        VERIFICAMOS SI LA CONTORASENA ES LA CORRECTA
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getContrasena())) {
            return lista.get(0); // DEVOLVEMOS EL USUARIO en caso de que el usuario y la contrasena sena las correctas
        } else {
            return null;
        }
    }

    // obtiene todos los usuarios que pertenencen a una comunidad por el id de la Comunidad
    @Override
    public List<Usuarios> obtenerUsuariosComunidad(int idComunidadUsuarioPertenence) {

        String query = "select u from Usuarios as u, Comunidad as c where u.comunidad.comunidad_id = :usuarioComunidadPerteneceId";
        List<Usuarios> listaUsuarios = entityManager.createQuery(query).setParameter("usuarioComunidadPerteneceId", idComunidadUsuarioPertenence).getResultList();

        if (listaUsuarios.isEmpty()) {
            return null;
        }

        return listaUsuarios;

    }

}
