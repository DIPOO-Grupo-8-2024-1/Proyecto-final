package test;

import persistencia.Persistencia;
import obraDeArte.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaTest {
    public static void main(String[] args) {
        try {
            Persistencia persistencia = new Persistencia("datos");

            // Crear algunas obras de arte para probar
            ObraDeArte escultura = new TipoEscultura("1", "La escultura", "Artista A", 2021, "Lugar A", "Propietario A", 1000.0, EstadoObraDeArte.DISPONIBLE, 2.0, 3.0, 1.5, "Bronce", 50.0, false, "Detalles de instalación");
            ObraDeArte pintura = new TipoPintura("2", "La pintura", "Artista B", 2020, "Lugar B", "Propietario B", 2000.0, EstadoObraDeArte.DISPONIBLE, 1.2, 1.8, "Acrílico", "Descripción de la pintura");
            ObraDeArte imagen = new TipoImagen("3", "La imagen", "Artista C", 2019, "Lugar C", "Propietario C", 500.0, EstadoObraDeArte.DISPONIBLE, "HD", "JPEG", "Descripción de la imagen");
            ObraDeArte impresion = new TipoImpresion("4", "La impresión", "Artista D", 2018, "Lugar D", "Propietario D", 300.0, EstadoObraDeArte.DISPONIBLE, "Papel de alta calidad", "Litografía", "Descripción de la impresión");
            ObraDeArte video = new TipoVideo("5", "El video", "Artista E", 2022, "Lugar E", "Propietario E", 1500.0, EstadoObraDeArte.DISPONIBLE, 3600, "mp4", "1080p", "Descripción del video");

            // Guardar las obras de arte
            List<ObraDeArte> obras = new ArrayList<>();
            obras.add(escultura);
            obras.add(pintura);
            obras.add(imagen);
            obras.add(impresion);
            obras.add(video);
            persistencia.guardarObras(obras);

            // Cargar las obras de arte
            List<ObraDeArte> obrasCargadas = persistencia.cargarObras();
            for (ObraDeArte obra : obrasCargadas) {
                System.out.println(obra);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

