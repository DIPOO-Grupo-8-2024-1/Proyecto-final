/**
 * 
 */
package obraDeArte;

/**
 * 
 */
public class TipoPintura extends ObraDeArte {
	
    private double alto;
    private double ancho;
    private String tecnica;
    private String descripcion;

    public TipoPintura(String id, String titulo, String artista, int anio, String lugarCreacion,
                   String propietarioId, double precioBase, EstadoObraDeArte estado,
                   double ancho, double alto, String tecnica, String descripcion) 	{
    	super(id, titulo, artista, anio, lugarCreacion, propietarioId, precioBase, estado);
        
        this.alto = alto;
        this.ancho = ancho;
        this.tecnica = tecnica;
        this.descripcion = descripcion;
    }							

    // Getters y Setters para los atributos específicos de Pintura
    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }
    
    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    
    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 // Implementación del método abstracto obtenerDescripcion()
    @Override
    public String obtenerDescripcion() {
        return "TipoPintura{" +
               "alto=" + alto +
               ", ancho=" + ancho +
               ", tecnica='" + tecnica + '\'' +
               ", descripcion='" + descripcion + '\'' +
               "} " + super.toString();
    }


    @Override
    public String toString() {
        return obtenerDescripcion();
    }
}


