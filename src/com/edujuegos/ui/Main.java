package com.edujuegos.ui;

import com.edujuegos.model.Usuario;
import com.edujuegos.service.UsuarioService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();

        // Insertar un nuevo usuario
        Usuario nuevoUsuario = new Usuario(0, "Carlos", "carlos@gmail.com", "password123");
        usuarioService.registrarUsuario(nuevoUsuario);

        // Consultar todos los usuarios
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        System.out.println("Lista de usuarios:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() + ", Correo: " + usuario.getCorreo());
        }

        // Actualizar un usuario existente
        Usuario usuarioExistente = usuarios.get(0);  // Asumiendo que el primer usuario es el que queremos actualizar
        usuarioExistente.setNombre("Carlos Updated");
        usuarioExistente.setContrasena("newpassword123");
        usuarioService.modificarUsuario(usuarioExistente);

        // Consultar usuarios nuevamente para verificar la actualización
        usuarios = usuarioService.obtenerUsuarios();
        System.out.println("Usuarios después de la actualización:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() + ", Correo: " + usuario.getCorreo());
        }

        // Eliminar un usuario por ID
        int idEliminar = usuarios.get(0).getId();  // Eliminar el primer usuario
        usuarioService.eliminarUsuario(idEliminar);

        // Consultar usuarios nuevamente para verificar la eliminación
        usuarios = usuarioService.obtenerUsuarios();
        System.out.println("Usuarios después de la eliminación:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() + ", Correo: " + usuario.getCorreo());
        }
    }
}
