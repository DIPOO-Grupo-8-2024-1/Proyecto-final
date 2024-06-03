package gui;

import gestion.Inventario;
import gestion.Subasta;
import usuario.PropietarioComprador;
import obraDeArte.ObraDeArte;

import javax.swing.*;
import java.awt.*;

public class PropietarioCompradorPanel extends JPanel {
    private PropietarioComprador usuario;
    private Inventario inventario;

    public PropietarioCompradorPanel(PropietarioComprador usuario, Inventario inventario) {
        this.usuario = usuario;
        this.inventario = inventario;
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel propietarioPanel = crearPanelPropietario();
        tabbedPane.add("Propietario", propietarioPanel);

        JPanel compradorPanel = crearPanelComprador();
        tabbedPane.add("Comprador", compradorPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel crearPanelPropietario() {
        JPanel panel = new JPanel(new BorderLayout());

        // Crear interfaz para gestionar las obras propias
        JButton agregarObraButton = new JButton("Agregar Obra");
        agregarObraButton.addActionListener(e -> agregarObra());
        panel.add(agregarObraButton, BorderLayout.NORTH);

        // Otras funcionalidades del propietario...

        return panel;
    }

    private JPanel crearPanelComprador() {
        JPanel panel = new JPanel(new BorderLayout());

        // Crear interfaz para realizar ofertas y ver compras realizadas
        JButton realizarOfertaButton = new JButton("Realizar Oferta");
        realizarOfertaButton.addActionListener(e -> realizarOferta());
        panel.add(realizarOfertaButton, BorderLayout.NORTH);

        // Otras funcionalidades del comprador...

        return panel;
    }

    private void agregarObra() {
        // Lógica para agregar una obra propia
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID de la obra:");
        String titulo = JOptionPane.showInputDialog(this, "Ingrese el título de la obra:");
        String artista = JOptionPane.showInputDialog(this, "Ingrese el nombre del artista:");
        int anio = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el año de creación:"));
        String lugarCreacion = JOptionPane.showInputDialog(this, "Ingrese el lugar de creación:");
        double precioBase = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese el precio base:"));

        ObraDeArte obra = new ObraDeArte(id, titulo, artista, anio, lugarCreacion, usuario.getId(), precioBase, EstadoObraDeArte.DISPONIBLE);
        usuario.agregarObra(obra);
        inventario.agregarObra(obra);
        JOptionPane.showMessageDialog(this, "Obra agregada con éxito.");
    }

    private void realizarOferta() {
        // Lógica para realizar una oferta
        String subastaId = JOptionPane.showInputDialog(this, "Ingrese el ID de la subasta:");
        Subasta subasta = inventario.consultarSubastas().stream().filter(s -> s.getId().equals(subastaId)).findFirst().orElse(null);

        if (subasta != null) {
            double valorOfrecido = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese el valor ofrecido:"));

            try {
                usuario.realizarOferta(subasta, valorOfrecido);
                JOptionPane.showMessageDialog(this, "Oferta realizada con éxito.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Subasta no válida.");
        }
    }
}
