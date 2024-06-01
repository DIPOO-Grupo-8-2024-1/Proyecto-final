/**
 * 
 */
package obraDeArte;

/**
 * 
 */
public class TipoImagen extends ObraDeArte {
    private String calidadImagen; // Ejemplo: "HD", "Retina"
    private String formato; // Ejemplo: "JPEG", "PNG"
    private String descripcion; // Descripción adicional sobre la imagen

    public TipoImagen(String id, String titulo, String artista, int anio, String lugarCreacion,
                      String propietarioId, double precioBase, EstadoObraDeArte estado,
                      String calidadImagen, String formato, String descripcion) {
        super(id, titulo, artista, anio, lugarCreacion, propietarioId, precioBase, estado);
        this.calidadImagen = calidadImagen;
        this.formato = formato;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getCalidadImagen() {
        return calidadImagen;
    }

    public void setCalidadImagen(String calidadImagen) {
        this.calidadImagen = calidadImagen;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String obtenerDescripcion() {
        return "TipoImagen{" +
               "calidadImagen='" + calidadImagen + '\'' +
               ", formato='" + formato + '\'' +
               ", descripcion='" + descripcion + '\'' +
               "} " + super.toString();
    }
}
