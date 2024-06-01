/**
 * 
 */
package usuario;

import obraDeArte.EstadoObraDeArte;
import oferta.Pago;
import gestion.Inventario;

/**
 * La clase Cajero extiende la clase Usuario y proporciona funcionalidades específicas 
 * necesarias para manejar los pagos y las transacciones financieras en el sistema de la galería de arte y casa de subastas.
 */
public class Cajero extends Usuario {
	
    private Inventario inventario;
	
    /**
     * Constructor para crear un nuevo cajero.
     * 
     * @param id El identificador único del cajero.
     * @param nombre El nombre completo del cajero.
     * @param correoElectronico El correo electrónico del cajero.
     * @param telefono El número de teléfono del cajero.
     */

    public Cajero(String id, String nombre, String correoElectronico, String telefono, Inventario inventario) {
        super(id, nombre, correoElectronico, telefono);
        this.inventario = inventario;
    }

    /**
     * Procesa un pago para una obra de arte vendida.
     * 
     * @param pago El objeto Pago que contiene los detalles de la transacción.
     */
    public void procesarPago(Pago pago) {
        if (pago == null) {
            System.out.println("Error: El pago no puede ser nulo.");
            return;
        }
        
        if (pago.getMonto() <= 0) {
            System.out.println("Error: El monto del pago debe ser positivo.");
            return;
        }

        // Confirmación manual del pago, registrado en el sistema sin terceros
        System.out.println("Pago procesado manualmente por el cajero " + getNombre() +
                           ": $" + pago.getMonto() + " mediante " + pago.getMetodo() +
                           ". Obra: " + pago.getObra().getTitulo() +
                           ", Comprador: " + pago.getComprador().getNombre());

        // Actualizar el estado de la obra en el inventario
        if (inventario.getObra(pago.getObra().getId()) != null) {
            pago.getObra().setEstado(EstadoObraDeArte.VENDIDA);
            inventario.actualizarObra(pago.getObra());
        } else {
            System.out.println("Error: La obra de arte no se encuentra en el inventario.");
        }

        // Registrar el pago en los registros financieros del sistema
        registrarPago(pago);
    }

    /**
     * Registra una devolución de una transacción previamente realizada.
     * 
     * @param pago El objeto Pago que contiene los detalles de la transacción a devolver.
     */
    public void registrarDevolucion(Pago pago) {
        if (pago == null) {
            System.out.println("Error: El pago no puede ser nulo.");
            return;
        }
        
        if (pago.getMonto() <= 0) {
            System.out.println("Error: El monto del pago debe ser positivo para realizar una devolución.");
            return;
        }

        // Comprobación de que la obra está actualmente vendida y puede ser devuelta
        if (pago.getObra() != null && pago.getObra().getEstado() == EstadoObraDeArte.VENDIDA) {
            // Proceso de devolución
            System.out.println("Procesando devolución de pago por " + getNombre() +
                               ": $" + pago.getMonto() + " devueltos para la obra '" + pago.getObra().getTitulo() + "'");
            
            // Actualizar el estado de la obra en el inventario
            pago.getObra().setEstado(EstadoObraDeArte.DISPONIBLE);
            inventario.actualizarObra(pago.getObra());

            // Revertir el pago en los registros financieros del sistema
            revertirPagoFinanciero(pago);
        } else {
            System.out.println("Error: No se puede procesar la devolución para una obra que no está vendida o es inexistente.");
        }
    }
    
    /**
     * Registra el pago en el sistema financiero interno de la galería.
     * 
     * @param pago El pago a registrar.
     */
    private void registrarPago(Pago pago) {
        // Lógica para registrar el pago en el sistema financiero (detalle simulado)
        System.out.println("Registro financiero: Pago de $" + pago.getMonto() + " para la obra '" +
                           pago.getObra().getTitulo() + "' registrado bajo el método '" + pago.getMetodo() + "'.");
    }
    
    /**
     * Revierte el pago en el sistema financiero interno de la galería.
     * 
     * @param pago El pago a revertir.
     */
    private void revertirPagoFinanciero(Pago pago) {
        // Lógica para revertir el pago en el sistema financiero (detalle simulado)
        System.out.println("Registro financiero: Devolución de $" + pago.getMonto() + " para la obra '" +
                           pago.getObra().getTitulo() + "' ha sido registrada bajo el método '" + pago.getMetodo() + "'.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Cajero: " + getNombre() + " - Email: " + getCorreoElectronico());
    }
}

