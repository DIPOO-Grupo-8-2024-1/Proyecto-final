/**
 * 
 */
package obraDeArte;

/**
 * 
 */
public class TipoEscultura extends ObraDeArte {
	
    private double alto;
    private double ancho;
    private double profundidad;
    private String material;
    private double peso;
    private boolean requiereElectricidad;
    private String descripcion;

    public TipoEscultura(String id, String titulo, String artista, int anio, String lugarCreacion,
                         String propietarioId, double precioBase, EstadoObraDeArte estado,
                         double alto, double ancho, double profundidad, String material, double peso,
                         boolean requiereElectricidad, String descripcion) {
        super(id, titulo, artista, anio, lugarCreacion, propietarioId, precioBase, estado);
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.material = material;
        this.peso = peso;
        this.requiereElectricidad = requiereElectricidad;
        this.descripcion = descripcion;
    }

    // Implementación de métodos getters y setters
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

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public boolean isRequiereElectricidad() {
        return requiereElectricidad;
    }

    public void setRequiereElectricidad(boolean requiereElectricidad) {
        this.requiereElectricidad = requiereElectricidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void serDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    @Override
    public String obtenerDescripcion() {
        String electricidadInfo = requiereElectricidad ? "requiere electricidad" : "no requiere electricidad";
        return "TipoEscultura{" +
               "alto=" + alto +
               ", ancho=" + ancho +
               ", profundidad=" + profundidad +
               ", material='" + material + '\'' +
               ", peso=" + peso +
               ", electricidad=" + electricidadInfo +
               ", descripcion='" + descripcion + '\'' +
               "} " + super.toString();
    }
    
    // Método para calcular el volumen de la escultura, si es relevante para el negocio
    public double calcularVolumen() {
        return alto * ancho * profundidad;
    }
}

