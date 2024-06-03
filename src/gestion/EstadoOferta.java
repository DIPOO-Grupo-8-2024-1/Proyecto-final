/**
 * 
 */
package gestion;

/**
 * 
 */
public enum EstadoOferta {
	
    PENDIENTE("pendiente"),
    APROBADA("aprobada"),
    RECHAZADA("rechazada");

    private final String estado;

    EstadoOferta(String estado) {
        this.estado = estado;
    }

    public String getEstadoOferta() {
        return this.estado;
    }
}
   