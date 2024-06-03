package gestion;

import java.io.Serializable;
import java.time.LocalDateTime;

import usuario.Usuario;

public class Pago implements Serializable {
    private String id;
    private String idComprador;
    private double monto;
    private LocalDateTime fechaPago;
    private MetodoDePago metodoPago;
    private EstadoPago estado;

    public Pago(String id, String idComprador, double monto, LocalDateTime fechaPago, MetodoDePago metodoPago, EstadoPago estado) {
        this.id = id;
        this.idComprador = idComprador;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public String getIdComprador() {
        return idComprador;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public MetodoDePago getMetodoPago() {
        return metodoPago;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public boolean procesarCompra(Inventario inventario) {
        // Validar si el comprador está verificado
        Usuario comprador = inventario.consultarUsuarioPorId(idComprador);
        if (comprador != null && comprador.isVerificado() && comprador.getLimiteCompra() >= monto) {
            // Registrar el pago
            this.estado = EstadoPago.COMPLETADO;
            comprador.incrementarLimiteCompra(-monto);
            inventario.actualizarUsuario(comprador);
            inventario.agregarPago(this);
            return true;
        } else {
            this.estado = EstadoPago.FALLIDO;
            inventario.agregarPago(this);
            return false;
        }
    }
}




