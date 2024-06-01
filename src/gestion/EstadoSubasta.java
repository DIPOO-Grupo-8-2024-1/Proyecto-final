/**
 * 
 */
package gestion;

/**
 * 
 */
public enum EstadoSubasta {
    EN_ESPERA("en espera"),
    EN_ACTIVA("activa"),
    FINALIZADA("finalizada");

    private final String estado;

    EstadoSubasta(String estado) {
        this.estado = estado;
    }

    public String getEstadoSubasta() {
        return this.estado;
    }
}
