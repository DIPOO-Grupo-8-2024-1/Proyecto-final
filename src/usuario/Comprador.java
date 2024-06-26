package usuario;

import gestion.EstadoOferta;
import gestion.Oferta;
import gestion.Subasta;
import obraDeArte.ObraDeArte;

import java.util.ArrayList;
import java.util.List;

public class Comprador extends Usuario {
    private List<Oferta> ofertas;
    private List<ObraDeArte> comprasRealizadas;

    public Comprador(String id, String nombre, String email, String password, boolean verificado, double limiteCompra) {
        super(id, nombre, email, password, verificado, limiteCompra);
        this.ofertas = new ArrayList<>();
        this.comprasRealizadas = new ArrayList<>();
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public List<ObraDeArte> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void realizarOferta(Subasta subasta, double valorOfrecido) {
        if (valorOfrecido >= subasta.getValorInicial() && this.getLimiteCompra() >= valorOfrecido) {
            Oferta oferta = new Oferta(
                "oferta_" + (ofertas.size() + 1), this.getId(), valorOfrecido, java.time.LocalDateTime.now(),
                EstadoOferta.PENDIENTE, subasta.getObra()
            );
            subasta.agregarOferta(oferta);
            this.ofertas.add(oferta);
        } else {
            throw new IllegalArgumentException("El valor ofrecido es menor que el valor inicial o supera el límite de compra del comprador.");
        }
    }

    public void agregarCompraRealizada(ObraDeArte obra) {
        this.comprasRealizadas.add(obra);
    }
}


