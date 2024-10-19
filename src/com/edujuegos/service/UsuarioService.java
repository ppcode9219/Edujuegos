package com.edujuegos.service;

import com.edujuegos.dao.UsuarioDAO;
import com.edujuegos.model.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    // Lógica de negocio para insertar usuario
    public void registrarUsuario(Usuario usuario) {
        if (usuario.getNombre() != null && usuario.getCorreo() != null) {
            usuarioDAO.insertarUsuario(usuario);
        }
    }

    // Lógica de negocio para consultar usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarioDAO.consultarUsuarios();
    }

    // Lógica de negocio para actualizar usuario
    public void modificarUsuario(Usuario usuario) {
        if (usuario.getId() > 0) {
            usuarioDAO.actualizarUsuario(usuario);
        }
    }

    // Lógica de negocio para eliminar usuario
    public void eliminarUsuario(int id) {
        if (id > 0) {
            usuarioDAO.eliminarUsuario(id);
        }
    }
}

