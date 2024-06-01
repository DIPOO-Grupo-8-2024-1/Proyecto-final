package usuario;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase base para todos los usuarios del sistema de la galería y casa de subastas.
 * Incluye soporte para roles dinámicos, permitiendo que un usuario tenga múltiples roles y capacidades.
 */
public abstract class Usuario {
    private String id;
    private String nombre;
    private String correoElectronico;
    private String telefono;
    private Set<String> roles;  // Conjunto de roles para soportar múltiples capacidades

    /**
     * Constructor para el usuario, inicializando con los datos básicos.
     * 
     * @param id Identificador único para el usuario.
     * @param nombre Nombre completo del usuario.
     * @param correoElectronico Correo electrónico del usuario.
     * @param telefono Teléfono de contacto del usuario.
     */
    public Usuario(String id, String nombre, String correoElectronico, String telefono) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (correoElectronico == null || !correoElectronico.contains("@")) {
            throw new IllegalArgumentException("Correo electrónico inválido.");
        }
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.roles = new HashSet<>();
    }

    // Métodos de manejo de roles
    public void addRole(String role) {
        roles.add(role);
    }

    public void removeRole(String role) {
        roles.remove(role);
    }

    public boolean hasRole(String role) {
        return roles.contains(role);
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getTelefono() { return telefono; }

    public Set<String> getRoles() {
        return Collections.unmodifiableSet(roles); // Return an unmodifiable view of the set
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        if (correoElectronico == null || !correoElectronico.contains("@")) {
            throw new IllegalArgumentException("Correo electrónico inválido.");
        }
        this.correoElectronico = correoElectronico;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método abstracto para mostrar información del usuario.
     * Este método debe ser implementado por todas las subclases para adecuarse a sus necesidades específicas.
     */
    public abstract void displayInfo();

    @Override
    public String toString() {
        return "Usuario{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", correoElectronico='" + correoElectronico + '\'' +
               ", telefono='" + telefono + '\'' +
               ", roles=" + roles +
               '}';
    }
}
