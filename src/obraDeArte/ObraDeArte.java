/**
 * La clase ObraDeArte servirá como la superclase para diferentes tipos de obras de arte,
 * abarcando los atributos comunes y proporcionando la estructura necesaria para 
 * gestionar su ciclo de vida dentro de la galería, desde su recepción hasta su venta o devolución.
 */
package obraDeArte;

public abstract class ObraDeArte {
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
        this.estado = estado;
        this.precioBase = precioBase;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getAnio() { return anio; }
    public String getLugarCreacion() { return lugarCreacion; }
    public String getPropietarioId() { return propietarioId; }
    public EstadoObraDeArte getEstado() { return estado; }
    public double getPrecioBase() { return precioBase; }

    public void setId(String id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setArtista(String artista) { this.artista = artista; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setLugarCreacion(String lugarCreacion) { this.lugarCreacion = lugarCreacion; }
    public void setPropietarioId(String propietarioId) { this.propietarioId = propietarioId; }
    public void setEstado(EstadoObraDeArte estado) { this.estado = estado; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    // Este método será implementado por las subclases
    public abstract String obtenerDescripcion();

    // Method to change the state of the piece of art
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

