package usuario;

import obraDeArte.ObraDeArte;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Propietario extiende la clase Usuario y proporciona funcionalidades específicas 
 * necesarias para los propietarios de obras de arte en el sistema de la galería de arte y casa de subastas.
 */
public class Propietario extends Usuario {
    private List<ObraDeArte> obras;  // Lista de obras de arte propiedad del usuario

    /**
     * Constructor para crear un nuevo propietario.
     * 
     * @param id El identificador único del propietario.
     * @param nombre El nombre completo del propietario.
     * @param correoElectronico El correo electrónico del propietario.
     * @param telefono El número de teléfono del propietario.
     */
    public Propietario(String id, String nombre, String correoElectronico, String telefono) {
        super(id, nombre, correoElectronico, telefono);
        this.obras = new ArrayList<>();
        addRole("propietario");
    }

    // Getters y Setters
    public List<ObraDeArte> getObras() {
        return obras;
    }

    /**
     * Añade una obra de arte a la lista de propiedades del propietario.
     * 
     * @param obra La obra de arte a añadir.
     */
    public void agregarObra(ObraDeArte obra) {
        if (!obras.contains(obra)) {
            obras.add(obra);
            System.out.println("Obra agregada a tu colección: " + obra.getTitulo());
        } else {
            System.out.println("Esta obra ya está en tu colección.");
        }
    }

    /**
     * Elimina una obra de arte de la lista de propiedades del propietario.
     * 
     * @param obra La obra de arte a eliminar.
     */
    public void eliminarObra(ObraDeArte obra) {
        if (obras.contains(obra)) {
            obras.remove(obra);
            System.out.println("Obra eliminada de tu colección: " + obra.getTitulo());
        } else {
            System.out.println("Esta obra no se encuentra en tu colección.");
        }
    }

    /**
     * Método para visualizar las obras de arte propiedad del propietario.
     */
    public void mostrarObras() {
        System.out.println("Obras en tu colección:");
        for (ObraDeArte obra : obras) {
            System.out.println(obra + " - Estado: " + obra.getEstado());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Propietario: " + getNombre() + " - Email: " + getCorreoElectronico());
    }
}

