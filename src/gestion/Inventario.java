package gestion;

import usuario.Usuario;
import obraDeArte.ObraDeArte;
import persistencia.Persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<ObraDeArte> obras;
    private List<Subasta> subastas;
    private List<Oferta> ofertas;
    private List<Pago> pagos;
    private List<Usuario> usuarios;
    private Persistencia persistencia;

    public Inventario(String directorioPersistencia) {
        this.persistencia = new Persistencia(directorioPersistencia);
        this.obras = new ArrayList<>();
        this.subastas = new ArrayList<>();
        this.ofertas = new ArrayList<>();
        this.pagos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        cargarObras();
        cargarSubastas();
        cargarOfertas();
        cargarPagos();
        cargarUsuarios();
    }

    private void cargarObras() {
        try {
            this.obras = persistencia.cargarObras();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void guardarObras() {
        try {
            persistencia.guardarObras(obras);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarSubastas() {
        try {
            this.subastas = persistencia.cargarSubastas();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void guardarSubastas() {
        try {
            persistencia.guardarSubastas(subastas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarOfertas() {
        try {
            this.ofertas = persistencia.cargarOfertas();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void guardarOfertas() {
        try {
            persistencia.guardarOfertas(ofertas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarPagos() {
        try {
            this.pagos = persistencia.cargarPagos();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void guardarPagos() {
        try {
            persistencia.guardarPagos(pagos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarUsuarios() {
        try {
            this.usuarios = persistencia.cargarUsuarios();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void guardarUsuarios() {
        try {
            persistencia.guardarUsuarios(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Usuario autenticarUsuario(String email, String password) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public void agregarObra(ObraDeArte obra) {
        obras.add(obra);
        guardarObras();
    }

    public void eliminarObra(String obraId) {
        obras.removeIf(obra -> obra.getId().equals(obraId));
        guardarObras();
    }

    public List<ObraDeArte> consultarObras() {
        return obras;
    }

    public ObraDeArte consultarObraPorId(String obraId) {
        return obras.stream().filter(obra -> obra.getId().equals(obraId)).findFirst().orElse(null);
    }

    public void agregarSubasta(Subasta subasta) {
        subastas.add(subasta);
        guardarSubastas();
    }

    public void eliminarSubasta(String subastaId) {
        subastas.removeIf(subasta -> subasta.getId().equals(subastaId));
        guardarSubastas();
    }

    public List<Subasta> consultarSubastas() {
        return subastas;
    }

    public Subasta consultarSubastaPorId(String subastaId) {
        return subastas.stream().filter(subasta -> subasta.getId().equals(subastaId)).findFirst().orElse(null);
    }

    public void agregarOferta(Oferta oferta) {
        ofertas.add(oferta);
        guardarOfertas();
    }

    public void eliminarOferta(String ofertaId) {
        ofertas.removeIf(oferta -> oferta.getId().equals(ofertaId));
        guardarOfertas();
    }

    public List<Oferta> consultarOfertas() {
        return ofertas;
    }

    public Oferta consultarOfertaPorId(String ofertaId) {
        return ofertas.stream().filter(oferta -> oferta.getId().equals(ofertaId)).findFirst().orElse(null);
    }

    public void agregarPago(Pago pago) {
        pagos.add(pago);
        guardarPagos();
    }

    public void eliminarPago(String pagoId) {
        pagos.removeIf(pago -> pago.getId().equals(pagoId));
        guardarPagos();
    }

    public List<Pago> consultarPagos() {
        return pagos;
    }

    public Pago consultarPagoPorId(String pagoId) {
        return pagos.stream().filter(pago -> pago.getId().equals(pagoId)).findFirst().orElse(null);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        guardarUsuarios();
    }

    public void eliminarUsuario(String usuarioId) {
        usuarios.removeIf(usuario -> usuario.getId().equals(usuarioId));
        guardarUsuarios();
    }

    public List<Usuario> consultarUsuarios() {
        return usuarios;
    }

    public Usuario consultarUsuarioPorId(String usuarioId) {
        return usuarios.stream().filter(usuario -> usuario.getId().equals(usuarioId)).findFirst().orElse(null);
    }
}



