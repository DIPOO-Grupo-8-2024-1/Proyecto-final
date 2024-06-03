package obraDeArte;

import java.io.Serializable;

/**
 * La clase ObraDeArte servirá como la superclase para diferentes tipos de obras de arte,
 * abarcando los atributos comunes y proporcionando la estructura necesaria para 
 * gestionar su ciclo de vida dentro de la galería, desde su recepción hasta su venta o devolución.
 */
public abstract class ObraDeArte implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String titulo;
    private String artista;
    private int anio;
    private String lugarCreacion;
    private String propietarioId;
    private double precioBase;
    private EstadoObraDeArte estado;

    public ObraDeArte(String id, String titulo, String artista, int anio, String lugarCreacion,
                      String propietarioId, double precioBase, EstadoObraDeArte estado) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.anio = anio;
        this.lugarCreacion = lugarCreacion;
        this.propietarioId = propietarioId;
        this.precioBase = precioBase;
        this.estado = estado;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getLugarCreacion() {
        return lugarCreacion;
    }

    public void setLugarCreacion(String lugarCreacion) {
        this.lugarCreacion = lugarCreacion;
    }

    public String getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(String propietarioId) {
        this.propietarioId = propietarioId;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public EstadoObraDeArte getEstado() {
        return estado;
    }

    public void setEstado(EstadoObraDeArte estado) {
        this.estado = estado;
    }

    // Método abstracto que será implementado por las subclases
    public abstract String obtenerDescripcion();

    // Método para cambiar el estado de la obra de arte
    public void cambiarEstado(EstadoObraDeArte nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public String toString() {
        return "ObraDeArte{" +
               "id='" + id + '\'' +
               ", titulo='" + titulo + '\'' +
               ", artista='" + artista + '\'' +
               ", anio=" + anio +
               ", lugarCreacion='" + lugarCreacion + '\'' +
               ", propietarioId='" + propietarioId + '\'' +
               ", estado=" + estado +
               ", precioBase=" + precioBase +
               '}';
    }
}


