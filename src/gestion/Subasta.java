/**
 * 
 */
package gestion;

import obraDeArte.ObraDeArte;
import usuario.Comprador;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import oferta.Oferta;

public class Subasta {
	
    private String nombre;
    private String descripcion;
    private EstadoSubasta estado; 
    private Map<String, Oferta> ofertas;

    public Subasta(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = EstadoSubasta.EN_ESPERA; 
        this.ofertas = new HashMap<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoSubasta getEstado() {
        return estado;
    }

    public void setEstado(EstadoSubasta estado) {
        this.estado = estado;
    }

    public Map<String, Oferta> getOfertas() {
        return ofertas;
    }

    // Métodos para la gestión de la subasta
    public void registrarOferta(Oferta oferta) {
        // Añade la oferta a la subasta
        ofertas.put(oferta.getOferta(), oferta);
    }

    public void iniciarSubasta() {

        if(estado == EstadoSubasta.EN_ESPERA) {
            estado = EstadoSubasta.EN_ACTIVA;
        }
    }

    public void finalizarSubasta() {
        // Cambia el estado de la subasta a 'FINALIZADA'
        estado = EstadoSubasta.FINALIZADA;

    }

}
