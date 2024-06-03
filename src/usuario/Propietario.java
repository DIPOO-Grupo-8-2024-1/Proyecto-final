package usuario;

import obraDeArte.ObraDeArte;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Usuario {
    private List<ObraDeArte> obrasPropias;

    public Propietario(String id, String nombre, String email, String password, boolean verificado, double limiteCompra) {
        super(id, nombre, email, password, verificado, limiteCompra);
        this.obrasPropias = new ArrayList<>();
    }

    public List<ObraDeArte> getObrasPropias() {
        return obrasPropias;
    }

    public void agregarObra(ObraDeArte obra) {
        obrasPropias.add(obra);
    }

    public void eliminarObra(String obraId) {
        obrasPropias.removeIf(obra -> obra.getId().equals(obraId));
    }

    public ObraDeArte consultarObra(String obraId) {
        return obrasPropias.stream().filter(obra -> obra.getId().equals(obraId)).findFirst().orElse(null);
    }
}


