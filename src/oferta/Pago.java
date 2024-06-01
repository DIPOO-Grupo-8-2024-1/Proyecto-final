/**
 * 
 */
package oferta;

import obraDeArte.ObraDeArte;
import usuario.Comprador;

public class Pago {
    private String id;
    private double monto;
    private String metodo;  // Ejemplos: "Tarjeta de Crédito", "Transferencia Bancaria", "Efectivo"
    private ObraDeArte obra;
    private Comprador comprador;

    public Pago(String id, double monto, String metodo, ObraDeArte obra, Comprador comprador) {
        this.id = id;
        this.monto = monto;
        this.metodo = metodo;
        this.obra = obra;
        this.comprador = comprador;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public ObraDeArte getObra() {
        return obra;
    }

    public Comprador getComprador() {
        return comprador;
    }

    @Override
    public String toString() {
        return "Pago{" +
               "id='" + id + '\'' +
               ", monto=" + monto +
               ", metodo='" + metodo + '\'' +
               ", obra='" + (obra != null ? obra.getTitulo() : "N/A") + '\'' +
               ", comprador='" + (comprador != null ? comprador.getNombre() : "N/A") + '\'' +
               '}';
    }
}

