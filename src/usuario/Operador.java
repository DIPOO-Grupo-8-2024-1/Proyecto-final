package usuario;

import gestion.Oferta;
import gestion.Subasta;
import gestion.EstadoOferta;
import gestion.EstadoSubasta;
import gestion.Inventario;

import java.util.List;

public class Operador extends Empleado {

    public Operador(String id, String nombre, String email, String password, boolean verificado, double limiteCompra) {
        super(id, nombre, email, password, verificado, limiteCompra);
    }

    @Override
    public void realizarTareaEspecifica() {
        // Implementación específica para operador
    }

    public void registrarOferta(Subasta subasta, Oferta oferta) {
        if (subasta.getEstado() == EstadoSubasta.EN_PROGRESO && oferta.getValorOfrecido() >= subasta.getValorInicial()) {
            subasta.agregarOferta(oferta);
            oferta.setEstado(EstadoOferta.PENDIENTE);
            System.out.println("Oferta registrada con éxito.");
        } else {
            System.out.println("No se pudo registrar la oferta. Verifique el estado de la subasta y el valor ofrecido.");
        }
    }

    public List<Oferta> listarOfertas(Subasta subasta) {
        return subasta.getOfertas();
    }
}



