package gestion;

import obraDeArte.ObraDeArte;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Subasta implements Serializable {
    private String id;
    private ObraDeArte obra;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double valorInicial;
    private double valorMinimo;
    private List<Oferta> ofertas;
    private EstadoSubasta estado;

    public Subasta(String id, ObraDeArte obra, LocalDateTime fechaInicio, LocalDateTime fechaFin, double valorInicial, double valorMinimo) {
        this.id = id;
        this.obra = obra;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorInicial = valorInicial;
        this.valorMinimo = valorMinimo;
        this.ofertas = new ArrayList<>();
        this.estado = EstadoSubasta.PENDIENTE;
    }

    public String getId() {
        return id;
    }

    public ObraDeArte getObra() {
        return obra;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public EstadoSubasta getEstado() {
        return estado;
    }

    public void setEstado(EstadoSubasta estado) {
        this.estado = estado;
    }

    public void agregarOferta(Oferta oferta) {
        ofertas.add(oferta);
    }

    public Oferta getOfertaGanadora() {
        if (ofertas.isEmpty()) {
            return null;
        }
        ofertas.sort((o1, o2) -> Double.compare(o2.getValorOfrecido(), o1.getValorOfrecido()));
        return ofertas.get(0).getValorOfrecido() >= valorMinimo ? ofertas.get(0) : null;
    }
}


