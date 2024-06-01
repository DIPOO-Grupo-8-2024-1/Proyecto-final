/**
 * 
 */
package usuario;

import java.util.ArrayList;
import java.util.List;
import obraDeArte.ObraDeArte;
import oferta.Oferta;
import obraDeArte.EstadoObraDeArte;

/**
 * La clase Comprador extiende la clase Usuario y proporciona funcionalidades adicionales 
 * que son necesarias para los compradores en el sistema de la galería de arte y casa de subastas.
 */
public class Comprador extends Usuario {
    private double creditoDisponible;  // Crédito máximo que el comprador puede utilizar para hacer ofertas
    private List<Oferta> historialOfertas;  // Historial de todas las ofertas realizadas por el comprador
    private List<ObraDeArte> comprasRealizadas;  // Obras de arte compradas por el comprador
    private ObraDeArte obraBloqueada;  // Obra de arte actualmente bloqueada para compra
    
    /**
     * Constructor para crear un nuevo comprador.
     * 
     * @param id El identificador único del comprador.
     * @param nombre El nombre completo del comprador.
     * @param correoElectronico El correo electrónico del comprador.
     * @param telefono El número de teléfono del comprador.
     * @param creditoInicial Crédito inicial asignado al comprador.
     */
    public Comprador(String id, String nombre, String correoElectronico, String telefono, double creditoInicial) {
        super(id, nombre, correoElectronico, telefono);
        this.creditoDisponible = creditoInicial;
        this.historialOfertas = new ArrayList<>();
        this.comprasRealizadas = new ArrayList<>();
        this.addRole("comprador");
    }

    // Getters y Setters
    public double getCreditoDisponible() {
        return creditoDisponible;
    }

    public void setCreditoDisponible(double creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }

    public List<Oferta> getHistorialOfertas() {
        return historialOfertas;
    }
    
    public List<ObraDeArte> getComprasRealizadas() {
        return comprasRealizadas;
    }    
    
    /**
     * Obtiene la obra de arte actualmente bloqueada para compra.
     *
     * @return La obra de arte bloqueada.
     */
    public ObraDeArte getObraBloqueada() {
        return this.obraBloqueada;
    }

    /**
     * Intenta bloquear una obra de arte para compra. La obra quedará bloqueada hasta que
     * sea verificada por un administrador.
     *
     * @param obra La obra de arte a bloquear.
     */
    public void bloquearCompra(ObraDeArte obra) {
        if (obra == null) {
            System.out.println("Error: La obra no puede ser nula.");
            return;
        }
        if (obra.getEstado() != EstadoObraDeArte.DISPONIBLE) {
            System.out.println("Error: La obra no está disponible para compra.");
            return;
        }
        if (obra.getPrecioBase() > this.creditoDisponible) {
            System.out.println("Error: Precio de la obra excede el límite de crédito disponible.");
            return;
        }

        obra.setEstado(EstadoObraDeArte.BLOQUEADA);
        this.obraBloqueada = obra;
        System.out.println("Obra bloqueada para verificación: " + obra.getTitulo());
    }
    
    /**
     * Libera la obra bloqueada sin comprarla, por ejemplo, si la compra no es aprobada.
     */
    public void liberarObraBloqueada() {
        if (this.obraBloqueada != null) {
            this.obraBloqueada.setEstado(EstadoObraDeArte.DISPONIBLE);
            this.obraBloqueada = null;
            System.out.println("Obra liberada y disponible para otros compradores.");
        }
    }

    /**
     * Añade una oferta al historial del comprador y ajusta el crédito disponible.
     * 
     * @param oferta La oferta a añadir.
     */
    public void hacerOferta(Oferta oferta) {
        if (oferta.getMontoOfrecido() <= creditoDisponible) {
            historialOfertas.add(oferta);
            creditoDisponible -= oferta.getMontoOfrecido();  // Reduce el crédito disponible
            System.out.println("Oferta realizada exitosamente por: " + oferta.getMontoOfrecido());
        } else {
            System.out.println("Crédito insuficiente para realizar la oferta.");
        }
    }
    
    /**
     * Finaliza la compra de la obra bloqueada, si ha sido aprobada por un administrador.
     */
    public void finalizarCompra() {
        if (this.obraBloqueada == null || this.obraBloqueada.getEstado() != EstadoObraDeArte.BLOQUEADA) {
            System.out.println("Error: No hay obra bloqueada pendiente de finalización.");
            return;
        }

        this.comprasRealizadas.add(this.obraBloqueada);
        this.creditoDisponible -= this.obraBloqueada.getPrecioBase();
        this.obraBloqueada.setEstado(EstadoObraDeArte.VENDIDA);
        System.out.println("Compra finalizada: " + this.obraBloqueada.getTitulo());
        this.obraBloqueada = null;  // Clear the reference to the blocked piece
    }
    
    /**
     * Aumenta el límite de crédito del comprador.
     *
     * @param aumento El monto para aumentar el límite de crédito.
     */
    public void aumentarLimiteCredito(double aumento) {
        if (aumento < 0) {
            System.out.println("Error: El aumento del límite de crédito no puede ser negativo.");
            return;
        }
        this.creditoDisponible += aumento;
        System.out.println("Límite de crédito incrementado a: $" + this.creditoDisponible);
    }

    /**
     * Consulta el historial de compras realizadas por el comprador.
     */
    public void consultarCompras() {
        System.out.println("Historial de compras de " + getNombre() + ":");
        for (ObraDeArte obra : this.comprasRealizadas) {
            System.out.println(obra.getTitulo() + " comprada por $" + obra.getPrecioBase());
        }
    }

    /**
     * Método para visualizar el historial de ofertas del comprador.
     */
    public void mostrarHistorialOfertas() {
        for (Oferta oferta : historialOfertas) {
            System.out.println(oferta);
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Comprador: " + getNombre() + " - Email: " + getCorreoElectronico() + 
                           " - Crédito disponible: $" + getCreditoDisponible());
    }
}

