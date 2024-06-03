package usuario;

import gestion.Oferta;
import gestion.Pago;
import gestion.MetodoDePago;
import gestion.EstadoPago;
import gestion.EstadoOferta;
import gestion.Inventario;

import java.time.LocalDateTime;

public class Cajero extends Empleado {

    public Cajero(String id, String nombre, String email, String password, boolean verificado, double limiteCompra) {
        super(id, nombre, email, password, verificado, limiteCompra);
    }

    @Override
    public void realizarTareaEspecifica() {
        // Implementación específica para cajero
    }

    public void registrarPago(Oferta oferta, MetodoDePago metodoDePago, Inventario inventario) {
        if (oferta.getEstado() == EstadoOferta.APROBADA) {
            Pago nuevoPago = new Pago(
                oferta.getId(), oferta.getIdComprador(), oferta.getValorOfrecido(),
                LocalDateTime.now(), metodoDePago, EstadoPago.PENDIENTE
            );
            if (nuevoPago.procesarCompra(inventario)) {
                nuevoPago.setEstado(EstadoPago.COMPLETADO);
                inventario.agregarPago(nuevoPago);
                oferta.setEstado(EstadoOferta.APROBADA);
                System.out.println("Pago registrado y compra completada.");
            } else {
                nuevoPago.setEstado(EstadoPago.FALLIDO);
                System.out.println("Error al procesar el pago.");
            }
        } else {
            System.out.println("La oferta no está aprobada.");
        }
    }
}




