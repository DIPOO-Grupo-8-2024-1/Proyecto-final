/**
 * 
 */
package gestion;

import java.util.ArrayList;
import java.util.List;

import obraDeArte.EstadoObraDeArte;
import obraDeArte.ObraDeArte;

public class GaleriaDeArte {
    private String nombre;
    private String ubicacion;
    private List<ObraDeArte> obrasDisponibles;
    private List<ObraDeArte> obrasVendidas;

    public GaleriaDeArte(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.obrasDisponibles = new ArrayList<>();
        this.obrasVendidas = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<ObraDeArte> getObrasDisponibles() {
        return obrasDisponibles;
    }

    public List<ObraDeArte> getObrasVendidas() {
        return obrasVendidas;
    }

    // Métodos para manejar las colecciones de obras de arte
    public void agregarObraDisponible(ObraDeArte obra) {
        obrasDisponibles.add(obra);
    }

    public void venderObra(ObraDeArte obra) {
        if (obrasDisponibles.contains(obra)) {
            obrasDisponibles.remove(obra);
            obrasVendidas.add(obra);
            // Aquí también podríamos cambiar el estado de la obra a VENDIDA.
            obra.setEstado(EstadoObraDeArte.VENDIDA);
        }
    }

    public void eliminarObraVendida(ObraDeArte obra) {
        obrasVendidas.remove(obra);
    }

    // Otros métodos útiles podrían incluir buscar por artista, título, etc.
}
