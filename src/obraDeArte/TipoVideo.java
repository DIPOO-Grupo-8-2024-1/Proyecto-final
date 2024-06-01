/**
 * 
 */
package obraDeArte;

/**
 * 
 */
public class TipoVideo extends ObraDeArte {
    private int duracion; // Duración del video en segundos
    private String formato; // Formato del video, ej: "mp4", "avi"
    private String calidad; // Calidad del video, ej: "1080p", "4K"
    private String descripcion; // Descripción adicional del video

    public TipoVideo(String id, String titulo, String artista, int anio, String lugarCreacion,
                     String propietarioId, double precioBase, EstadoObraDeArte estado,
                     int duracion, String formato, String calidad, String descripcion) {
        super(id, titulo, artista, anio, lugarCreacion, propietarioId, precioBase, estado);
        this.duracion = duracion;
        this.formato = formato;
        this.calidad = calidad;
        this.descripcion = descripcion;
    }

    // Implementación de métodos getters y setters aquí
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String obtenerDescripcion() {
        return "TipoVideo{" +
               "duracion=" + duracion +
               ", formato='" + formato + '\'' +
               ", calidad='" + calidad + '\'' +
               ", descripcion='" + descripcion + '\'' +
               "} " + super.toString();
    }
    
    // Método adicional para convertir la duración en formato HH:MM:SS
    public String getDuracionFormatoHMS() {
        int horas = duracion / 3600;
        int minutos = (duracion % 3600) / 60;
        int segundos = duracion % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}

