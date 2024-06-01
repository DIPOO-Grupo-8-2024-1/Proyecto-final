/**
 * 
 */
package usuario;

import gestion.Inventario;
import obraDeArte.EstadoObraDeArte;
import obraDeArte.ObraDeArte;
import usuario.Comprador;
import oferta.Oferta;
import oferta.EstadoOferta;

/**
 * Clase Administrador que extiende de Usuario y tiene capacidades específicas
 * para gestionar el inventario y las transacciones de la galería.
 */
public class Administrador extends Usuario {
    private Inventario inventario;

    /**
     * Constructor para el administrador.
     * 
     * @param id Identificador único para el administrador.
     * @param nombre Nombre completo del administrador.
     * @param correoElectronico Correo electrónico del administrador.
     * @param telefono Teléfono de contacto del administrador.
     * @param inventario Referencia al inventario de la galería que el administrador puede gestionar.
     */
    public Administrador(String id, String nombre, String correoElectronico, String telefono, Inventario inventario) {
        super(id, nombre, correoElectronico, telefono);
        this.inventario = inventario;
        this.addRole("administrador");  // Assign the role of administrador automatically
    }

    @Override
    public void displayInfo() {
        System.out.println("Administrador: " + getNombre() + " - Email: " + getCorreoElectronico());
    }

    /**
     * Método para gestionar el inventario, por ejemplo, añadir o eliminar obras de arte.
     * @param obra Obra de arte a añadir o eliminar.
     * @param agregar true para añadir, false para eliminar.
     */
    public void gestionarInventario(ObraDeArte obra, boolean agregar) {
        if (obra == null) {
            System.out.println("Error: La obra no puede ser nula.");
            return;
        }
        if (agregar) {
            inventario.agregarObra(obra);
            System.out.println("Añadiendo obra de arte al inventario: " + obra.getTitulo());
        } else {
            inventario.eliminarObra(obra.getId());
            System.out.println("Eliminando obra de arte del inventario: " + obra.getTitulo());
        }
    }
    
    /**
     * Registra una obra de arte en el inventario.
     * 
     * @param obra La obra de arte a registrar.
     */
    public void registrarObra(ObraDeArte obra) {
        if (obra != null) {
            inventario.agregarObra(obra);
            System.out.println("Obra registrada en el inventario por " + getNombre() + ": " + obra.getTitulo());
        } else {
            System.out.println("Error: Intento de registrar una obra nula.");
        }
    }
    
    /**
     * Confirma una transacción, ya sea una venta o una devolución.
     * 
     * @param obra La obra de arte cuya transacción se está confirmando.
     * @param esVenta Indica si la transacción es una venta (true) o una devolución (false).
     */
    public void confirmarTransaccion(ObraDeArte obra, boolean esVenta) {
        if (obra != null) {
            String transactionType = esVenta ? "venta" : "devolución";
            obra.setEstado(esVenta ? EstadoObraDeArte.VENDIDA : EstadoObraDeArte.DISPONIBLE);
            System.out.println("Transacción de " + transactionType + " confirmada por " + getNombre() + ": " + obra.getTitulo());
        } else {
            System.out.println("Error: Intento de confirmar transacción para una obra nula.");
        }
    }

    /**
     * Verifica un comprador y establece o ajusta su límite de crédito.
     * 
     * @param comprador El comprador a verificar.
     * @param nuevoLimite El nuevo límite de crédito a establecer.
     */
    public void verificarComprador(Comprador comprador, double nuevoLimite) {
        if (comprador != null && nuevoLimite >= 0) {
            comprador.setCreditoDisponible(nuevoLimite);
            System.out.println("Límite de crédito ajustado por " + getNombre() + " para " + comprador.getNombre() + ": $" + nuevoLimite);
        } else {
            System.out.println("Error: Datos inválidos para verificar comprador.");
        }
    }
    
    /**
     * Método para aprobar o rechazar una oferta de compra o subasta.
     * @param oferta Oferta a evaluar.
     * @param aprobar true para aprobar, false para rechazar.
     */
    public void evaluarOferta(Oferta oferta, boolean aprobar) {
        if (aprobar) {
            oferta.setEstado(EstadoOferta.APROBADA);
            System.out.println("Oferta aprobada para la obra: " + oferta.getObraDeArte().getTitulo());
        } else {
            oferta.setEstado(EstadoOferta.RECHAZADA);
            System.out.println("Oferta rechazada para la obra: " + oferta.getObraDeArte().getTitulo());
        }
    }
    
    /**
     * Actualiza los detalles de una obra de arte existente en el inventario.
     * Este método asegura que solo las obras que existen en el inventario pueden ser actualizadas,
     * previniendo errores de integridad de datos. Es usado principalmente para modificar atributos
     * de la obra como el estado, precio, o detalles específicos después de evaluaciones o cambios.
     *
     * @param obra La obra de arte con los detalles actualizados.
     */
    public void actualizarObra(ObraDeArte obra) {
        if (obra == null) {
            System.out.println("Error: La obra no puede ser nula.");
            return;
        }

        ObraDeArte obraExistente = inventario.getObra(obra.getId());
        if (obraExistente == null) {
            System.out.println("Error: La obra con ID " + obra.getId() + " no existe en el inventario.");
            return;
        }

        // Actualizar la obra en el inventario. Esta operación puede incluir cambiar el estado
        // de la obra, ajustar su precio, actualizar descripciones, etc.
        inventario.actualizarObra(obra);
        System.out.println("Obra actualizada en el inventario por " + getNombre() + ": " + obra.getTitulo());
    }
    
    /**
     * Aprueba o rechaza la compra bloqueada de un comprador.
     * Si la compra es aprobada, la obra se marca como vendida y se finaliza la transacción.
     * Si es rechazada, la obra vuelve a estar disponible.
     *
     * @param comprador El comprador cuya compra está pendiente de aprobación.
     * @param aprobar true para aprobar la compra, false para rechazarla.
     */
    public void aprobarCompra(Comprador comprador, boolean aprobar) {
        ObraDeArte obra = comprador.getObraBloqueada();
        if (obra == null) {
            System.out.println("Error: No hay obra bloqueada pendiente de compra para este comprador.");
            return;
        }

        if (aprobar) {
            if (obra.getPrecioBase() > comprador.getCreditoDisponible()) {
                System.out.println("Error: El comprador no tiene suficiente crédito para la compra.");
                // Opcionalmente, podría incrementarse el límite de crédito aquí o requerir otra validación.
                return;
            }
            comprador.finalizarCompra();  // Finaliza la compra si está todo en orden.
            System.out.println("Compra aprobada: " + obra.getTitulo());
        } else {
            obra.setEstado(EstadoObraDeArte.DISPONIBLE);  // Rechazar la compra, hacer la obra disponible de nuevo.
            comprador.liberarObraBloqueada();  // Limpia la referencia a la obra bloqueada.
            System.out.println("Compra rechazada: " + obra.getTitulo());
        }
    }

    /**
     * Ajusta el límite de crédito de un comprador, usualmente tras la verificación de su capacidad de pago.
     *
     * @param comprador El comprador cuyo límite de crédito se va a ajustar.
     * @param nuevoLimite El nuevo límite de crédito a establecer.
     */
    public void ajustarLimiteCredito(Comprador comprador, double nuevoLimite) {
        if (nuevoLimite < 0) {
            System.out.println("Error: El nuevo límite de crédito no puede ser negativo.");
            return;
        }
        comprador.aumentarLimiteCredito(nuevoLimite);
        System.out.println("Límite de crédito ajustado para " + comprador.getNombre() + " a $" + nuevoLimite);
    }

}

