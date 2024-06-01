/**
 * 
 */
package obraDeArte;

public class TipoImpresion extends ObraDeArte {
    private String tipoMaterial; // Ejemplo: "Lienzo", "Papel de alta calidad"
    private String tecnicaImpresion; // Ejemplo: "Litografía", "Giclée"
    private String descripcion; // Descripción adicional sobre la impresión

    public TipoImpresion(String id, String titulo, String artista, int anio, String lugarCreacion,
                         String propietarioId, double precioBase, EstadoObraDeArte estado,
                         String tipoMaterial, String tecnicaImpresion, String descripcion) {
        super(id, titulo, artista, anio, lugarCreacion, propietarioId, precioBase, estado);
        this.tipoMaterial = tipoMaterial;
        this.tecnicaImpresion = tecnicaImpresion;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getTecnicaImpresion() {
        return tecnicaImpresion;
    }

    public void setTecnicaImpresion(String tecnicaImpresion) {
        this.tecnicaImpresion = tecnicaImpresion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String obtenerDescripcion() {
        return "TipoImpresion{" +
               "tipoMaterial='" + tipoMaterial + '\'' +
               ", tecnicaImpresion='" + tecnicaImpresion + '\'' +
               ", descripcion='" + descripcion + '\'' +
               "} " + super.toString();
    }
}
