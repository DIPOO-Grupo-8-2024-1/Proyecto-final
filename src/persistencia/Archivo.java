package persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Archivo {
    private String ruta;

    public Archivo(String ruta) {
        this.ruta = ruta;
    }

    public String leerArchivo() throws IOException {
        return new String(Files.readAllBytes(Paths.get(ruta)));
    }

    public void escribirArchivo(String contenido) throws IOException {
        Files.write(Paths.get(ruta), contenido.getBytes());
    }

    public boolean existe() {
        return Files.exists(Paths.get(ruta));
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
