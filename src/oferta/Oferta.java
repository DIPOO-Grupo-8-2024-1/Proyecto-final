/**
 * 
 */
package oferta;

import obraDeArte.ObraDeArte;
import usuario.Comprador;

public class Oferta {
    private ObraDeArte obra;
    private Comprador comprador;
    private double montoOfrecido;
    private EstadoOferta estado;

    public Oferta(ObraDeArte obra, Comprador comprador, double montoOfrecido) {
        this.obra = obra;
        this.comprador = comprador;
        this.montoOfrecido = montoOfrecido;
        this.estado = EstadoOferta.PENDIENTE;
    }

    // Getters y Setters
    public ObraDeArte getObraDeArte() {
        return obra;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public double getMontoOfrecido() {
        return montoOfrecido;
    }

    public EstadoOferta getEstado() {
        return estado;
    }

    public void setEstado(EstadoOferta estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Oferta{" +
               "obra=" + obra.getTitulo() +
               ", comprador=" + comprador.getNombre() +
               ", montoOfrecido=" + montoOfrecido +
               ", estado=" + estado +
               '}';
    }
}

