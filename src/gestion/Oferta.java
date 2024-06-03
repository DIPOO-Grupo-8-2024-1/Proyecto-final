package gestion;

import obraDeArte.ObraDeArte;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Oferta implements Serializable {
    private String id;
    private String idComprador;
    private double valorOfrecido;
    private LocalDateTime fechaOferta;
    private EstadoOferta estado;
    private ObraDeArte obra;  //

    public Oferta(String id, String idComprador, double valorOfrecido, LocalDateTime fechaOferta, EstadoOferta estado, ObraDeArte obra) {
        this.id = id;
        this.idComprador = idComprador;
        this.valorOfrecido = valorOfrecido;
        this.fechaOferta = fechaOferta;
        this.estado = estado;
        this.obra = obra;  
    }

    public String getId() {
        return id;
    }

    public String getIdComprador() {
        return idComprador;
    }

    public double getValorOfrecido() {
        return valorOfrecido;
    }

    public LocalDateTime getFechaOferta() {
        return fechaOferta;
    }

    public EstadoOferta getEstado() {
        return estado;
    }

    public void setEstado(EstadoOferta estado) {
        this.estado = estado;
    }

    public ObraDeArte getObra() { 
        return obra;
    }
}






