/**
 * 
 */
package gestion;

import java.util.HashMap;
import java.util.Map;
import obraDeArte.ObraDeArte;

/**
 * 
 */
public class Inventario {
    private HashMap<String, ObraDeArte> obras;

    public Inventario() {
        this.obras = new HashMap<>();
    }

    /**
     * Añade una obra de arte al inventario si aún no está presente.
     * 
     * @param obra La obra de arte a añadir.
     */
    public void agregarObra(ObraDeArte obra) {
        if (obra != null && !obras.containsKey(obra.getId())) {
            obras.put(obra.getId(), obra);
            System.out.println("Obra agregada al inventario: " + obra.getTitulo());
        } else {
            System.out.println("Error: La obra ya existe en el inventario o es inválida.");
        }
    }

    /**
     * Elimina una obra de arte del inventario.
     * 
     * @param obraId El ID de la obra de arte a eliminar.
     * @return La obra de arte eliminada, o null si no existía en el inventario.
     */
    public ObraDeArte eliminarObra(String obraId) {
        if (obras.containsKey(obraId)) {
            System.out.println("Obra eliminada del inventario: " + obras.get(obraId).getTitulo());
            return obras.remove(obraId);
        } else {
            System.out.println("Error: La obra no existe en el inventario.");
            return null;
        }
    }

    /**
     * Actualiza los detalles de una obra de arte existente en el inventario.
     * 
     * @param obra La obra de arte con los detalles actualizados.
     */
    public void actualizarObra(ObraDeArte obra) {
        if (obra != null && obras.containsKey(obra.getId())) {
            obras.put(obra.getId(), obra);  // Reemplaza la entrada existente con la actualizada
            System.out.println("Obra actualizada en el inventario: " + obra.getTitulo());
        } else {
            System.out.println("Error: No se puede actualizar porque la obra no existe en el inventario.");
        }
    }
    
    /**
     * Obtiene una obra de arte del inventario por su ID.
     * 
     * @param obraId El ID de la obra de arte.
     * @return La obra de arte, o null si no existe en el inventario.
     */
    public ObraDeArte getObra(String obraId) {
        return obras.get(obraId);
    }
}
