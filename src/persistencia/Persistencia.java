package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import gestion.Oferta;
import gestion.Pago;
import gestion.Subasta;
import obraDeArte.ObraDeArte;
import usuario.Usuario;

public class Persistencia {
    private String directorio;

    public Persistencia(String directorio) {
        this.directorio = directorio;
        // Crear el directorio si no existe
        File dir = new File(directorio);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public void guardarObras(List<ObraDeArte> obras) throws IOException {
        for (ObraDeArte obra : obras) {
            guardarObra(obra);
        }
    }

    public void guardarObra(ObraDeArte obra) throws IOException {
        String rutaArchivo = directorio + File.separator + obra.getId() + ".dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(obra);
        }
    }

    public List<ObraDeArte> cargarObras() throws IOException, ClassNotFoundException {
        List<ObraDeArte> obras = new ArrayList<>();
        File dir = new File(directorio);
        if (dir.exists() && dir.isDirectory()) {
            for (File archivo : dir.listFiles()) {
                if (archivo.isFile() && archivo.getName().endsWith(".dat")) {
                    obras.add(cargarObra(archivo));
                }
            }
        }
        return obras;
    }

    public ObraDeArte cargarObra(File archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ObraDeArte) ois.readObject();
        }
    }

    public void guardarSubastas(List<Subasta> subastas) throws IOException {
        String rutaArchivo = directorio + File.separator + "subastas.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(subastas);
        }
    }

    public List<Subasta> cargarSubastas() throws IOException, ClassNotFoundException {
        String rutaArchivo = directorio + File.separator + "subastas.dat";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                return (List<Subasta>) ois.readObject();
            }
        }
        return new ArrayList<>();
    }
    
    public void guardarOfertas(List<Oferta> ofertas) throws IOException {
        String rutaArchivo = directorio + File.separator + "ofertas.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(ofertas);
        }
    }

    public List<Oferta> cargarOfertas() throws IOException, ClassNotFoundException {
        String rutaArchivo = directorio + File.separator + "ofertas.dat";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                return (List<Oferta>) ois.readObject();
            }
        }
        return new ArrayList<>();
    }
    
    public void guardarPagos(List<Pago> pagos) throws IOException {
        String rutaArchivo = directorio + File.separator + "pagos.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(pagos);
        }
    }

    public List<Pago> cargarPagos() throws IOException, ClassNotFoundException {
        String rutaArchivo = directorio + File.separator + "pagos.dat";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                return (List<Pago>) ois.readObject();
            }
        }
        return new ArrayList<>();
    }
    
    public void guardarUsuarios(List<Usuario> usuarios) throws IOException {
        String rutaArchivo = directorio + File.separator + "usuarios.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(usuarios);
        }
    }

    public List<Usuario> cargarUsuarios() throws IOException, ClassNotFoundException {
        String rutaArchivo = directorio + File.separator + "usuarios.dat";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                return (List<Usuario>) ois.readObject();
            }
        }
        return new ArrayList<>();
    }
}



