package gestion;

public enum EstadoSubasta {
    PENDIENTE("pendiente"),  // La subasta ha sido creada pero aún no ha comenzado
    EN_PROGRESO("en progreso"),  // La subasta está en curso
    FINALIZADA("finalizada");  // La subasta ha finalizado

    private final String estado;

    EstadoSubasta(String estado) {
        this.estado = estado;
    }

    public String getEstadoSubasta() {
        return this.estado;
    }
}
