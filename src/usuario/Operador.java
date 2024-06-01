/**
 * 
 */
package usuario;

import gestion.Subasta;
import oferta.Oferta;

/**
 * La clase Operador extiende la clase Usuario y proporciona funcionalidades específicas 
 * necesarias para gestionar las subastas en el sistema de la galería de arte y casa de subastas.
 */
public class Operador extends Usuario {
    /**
     * Constructor para crear un nuevo operador.
     * 
     * @param id El identificador único del operador.
     * @param nombre El nombre completo del operador.
     * @param correoElectronico El correo electrónico del operador.
     * @param telefono El número de teléfono del operador.
     */
    public Operador(String id, String nombre, String correoElectronico, String telefono) {
        super(id, nombre, correoElectronico, telefono);
    }

    /**
     * Inicia una subasta específica.
     * 
     * @param subasta La subasta a iniciar.
     */
    public void iniciarSubasta(Subasta subasta) {
        if (!subasta.isActiva()) {
            subasta.iniciarSubasta();
            System.out.println("Subasta iniciada por el operador: " + getNombre());
        } else {
            System.out.println("La subasta ya está en curso.");
        }
    }

    /**
     * Finaliza una subasta específica.
     * 
     * @param subasta La subasta a finalizar.
     */
    public void finalizarSubasta(Subasta subasta) {
        if (subasta.isActiva()) {
            subasta.finalizarSubasta();
            System.out.println("Subasta finalizada por el operador: " + getNombre());
        } else {
            System.out.println("La subasta ya está finalizada o no ha comenzado.");
        }
    }

    /**
     * Registra una oferta en una subasta específica.
     * 
     * @param subasta La subasta donde se registra la oferta.
     * @param oferta La oferta a registrar.
     */
    public void registrarOferta(Subasta subasta, Oferta oferta) {
        if (subasta.isActiva() && subasta.getObras().contains(oferta.getObraDeArte())) {
            subasta.registrarOferta(oferta);
            System.out.println("Oferta registrada por " + oferta.getComprador().getNombre() + " en la subasta gestionada por " + getNombre());
        } else {
            System.out.println("La subasta no está activa o la obra no está en subasta.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Operador: " + getNombre() + " - Email: " + getCorreoElectronico());
    }
}
