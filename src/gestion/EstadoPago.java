package gestion;

public enum EstadoPago {
    PENDIENTE,  // El pago ha sido iniciado pero aún no ha sido completado
    COMPLETADO, // El pago ha sido completado exitosamente
    FALLIDO     // El pago ha fallado
}
