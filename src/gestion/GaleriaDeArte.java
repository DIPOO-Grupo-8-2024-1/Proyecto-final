package gestion;

import obraDeArte.ObraDeArte;
import usuario.Usuario;

import java.util.List;

public class GaleriaDeArte {
    private Inventario inventario;

    public GaleriaDeArte(String directorioPersistencia) {
        this.inventario = new Inventario(directorioPersistencia);
    }

    // Métodos para manejar el inventario
    public void agregarObra(ObraDeArte obra) {
        inventario.agregarObra(obra);
    }

    public List<ObraDeArte> consultarObras() {
        return inventario.consultarObras();
    }

    public void actualizarObra(String id, ObraDeArte obraActualizada) {
        inventario.actualizarObra(id, obraActualizada);
    }

    public void eliminarObra(String id) {
        inventario.eliminarObra(id);
    }

    // Métodos para manejar subastas
    public void agregarSubasta(Subasta subasta) {
        inventario.agregarSubasta(subasta);
    }

    public List<Subasta> consultarSubastas() {
        return inventario.consultarSubastas();
    }

    // Métodos para manejar ofertas
    public void agregarOferta(Oferta oferta) {
        inventario.agregarOferta(oferta);
    }

    public List<Oferta> consultarOfertas() {
        return inventario.consultarOfertas();
    }

    // Métodos para manejar pagos
    public void agregarPago(Pago pago) {
        inventario.agregarPago(pago);
    }

    public List<Pago> consultarPagos() {
        return inventario.consultarPagos();
    }

    // Métodos para manejar usuarios
    public void agregarUsuario(Usuario usuario) {
        inventario.agregarUsuario(usuario);
    }

    public Usuario consultarUsuarioPorId(String id) {
        return inventario.consultarUsuarioPorId(id);
    }

    public void actualizarUsuario(Usuario usuario) {
        inventario.actualizarUsuario(usuario);
    }

    public boolean procesarCompra(Oferta oferta, MetodoDePago metodoPago) {
        Pago nuevoPago = new Pago(
            oferta.getId(), oferta.getIdComprador(), oferta.getValorOfrecido(),
            java.time.LocalDateTime.now(), metodoPago, EstadoPago.PENDIENTE
        );
        return nuevoPago.procesarCompra(inventario);
    }
}


