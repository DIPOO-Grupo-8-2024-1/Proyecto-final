package usuario;

import gestion.EstadoOferta;
import gestion.Inventario;
import gestion.Oferta;
import obraDeArte.ObraDeArte;

public class Administrador extends Usuario {
    public Administrador(String id, String nombre, String email, String password, boolean verificado, double limiteCompra) {
        super(id, nombre, email, password, verificado, limiteCompra);
    }

    // Métodos específicos para el administrador pueden ser añadidos aquí
    public void aprobarOferta(Oferta oferta) {
        oferta.setEstado(EstadoOferta.APROBADA);
    }

    public void rechazarOferta(Oferta oferta) {
        oferta.setEstado(EstadoOferta.RECHAZADA);
    }

    public void agregarObra(Inventario inventario, ObraDeArte obra) {
        inventario.agregarObra(obra);
    }

    public void eliminarObra(Inventario inventario, String obraId) {
        inventario.eliminarObra(obraId);
    }
}

