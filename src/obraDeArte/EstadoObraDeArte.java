/**
 * 
 */
package obraDeArte;

/**
 * 
 */
public enum EstadoObraDeArte {
	
    BLOQUEADA("bloqueada"),
    DISPONIBLE("disponible"),
    VENDIDA("vendida"),
    BODEGA("bodega"),
    CONSIGNADA("consignada");

    private final String estado;

    EstadoObraDeArte(String estado) {
        this.estado = estado;
    }

    public String getEstadoObra() {
        return this.estado;
    }
}

