package usuario;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado extends Usuario {
    private List<String> responsabilidades;

    public Empleado(String id, String nombre, String email, String password, boolean verificado, double limiteCompra) {
        super(id, nombre, email, password, verificado, limiteCompra);
        this.responsabilidades = new ArrayList<>();
    }

    public List<String> getResponsabilidades() {
        return responsabilidades;
    }

    public void agregarResponsabilidad(String responsabilidad) {
        responsabilidades.add(responsabilidad);
    }

    public void eliminarResponsabilidad(String responsabilidad) {
        responsabilidades.remove(responsabilidad);
    }

    // Métodos abstractos que serán implementados por Cajero y Operador
    public abstract void realizarTareaEspecifica();
}
