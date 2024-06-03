package gui;

import gestion.Inventario;
import obraDeArte.ObraDeArte;
import obraDeArte.EstadoObraDeArte;
import obraDeArte.TipoEscultura;
import obraDeArte.TipoImagen;
import obraDeArte.TipoImpresion;
import obraDeArte.TipoPintura;
import obraDeArte.TipoVideo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarActualizarObraDialog extends JDialog {
    private Inventario inventario;
    private ObraDeArte obraExistente;

    private JTextField idField;
    private JTextField tituloField;
    private JTextField artistaField;
    private JTextField anioField;
    private JTextField lugarField;
    private JTextField propietarioField;
    private JTextField precioField;
    private JComboBox<String> estadoComboBox;
    private JComboBox<String> tipoObraComboBox;
    private JTextField descripcionField;

    public AgregarActualizarObraDialog(Frame owner, Inventario inventario, ObraDeArte obraExistente) {
        super(owner, "Agregar/Actualizar Obra de Arte", true);
        this.inventario = inventario;
        this.obraExistente = obraExistente;

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(10, 2));
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Título:"));
        tituloField = new JTextField();
        formPanel.add(tituloField);

        formPanel.add(new JLabel("Artista:"));
        artistaField = new JTextField();
        formPanel.add(artistaField);

        formPanel.add(new JLabel("Año:"));
        anioField = new JTextField();
        formPanel.add(anioField);

        formPanel.add(new JLabel("Lugar de Creación:"));
        lugarField = new JTextField();
        formPanel.add(lugarField);

        formPanel.add(new JLabel("Propietario ID:"));
        propietarioField = new JTextField();
        formPanel.add(propietarioField);

        formPanel.add(new JLabel("Precio Base:"));
        precioField = new JTextField();
        formPanel.add(precioField);

        formPanel.add(new JLabel("Estado:"));
        estadoComboBox = new JComboBox<>(new String[]{"DISPONIBLE", "VENDIDA", "EN_SUBASTA", "NO_DISPONIBLE", "DEVUELTA"});
        formPanel.add(estadoComboBox);

        formPanel.add(new JLabel("Tipo de Obra:"));
        tipoObraComboBox = new JComboBox<>(new String[]{"Escultura", "Imagen", "Impresion", "Pintura", "Video"});
        formPanel.add(tipoObraComboBox);

        formPanel.add(new JLabel("Descripción:"));
        descripcionField = new JTextField();
        formPanel.add(descripcionField);

        add(formPanel, BorderLayout.CENTER);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarObra();
            }
        });
        add(guardarButton, BorderLayout.SOUTH);

        if (obraExistente != null) {
            cargarDatosObra();
        }

        pack();
        setLocationRelativeTo(owner);
    }

    private void cargarDatosObra() {
        idField.setText(obraExistente.getId());
        idField.setEnabled(false);
        tituloField.setText(obraExistente.getTitulo());
        artistaField.setText(obraExistente.getArtista());
        anioField.setText(String.valueOf(obraExistente.getAnio()));
        lugarField.setText(obraExistente.getLugarCreacion());
        propietarioField.setText(obraExistente.getPropietarioId());
        precioField.setText(String.valueOf(obraExistente.getPrecioBase()));
        estadoComboBox.setSelectedItem(obraExistente.getEstado().name());
        descripcionField.setText(obraExistente.obtenerDescripcion()); // Añadir método getDescripcion() en ObraDeArte si es necesario
    }

    private void guardarObra() {
        try {
            String id = idField.getText();
            String titulo = tituloField.getText();
            String artista = artistaField.getText();
            int anio = Integer.parseInt(anioField.getText());
            String lugar = lugarField.getText();
            String propietarioId = propietarioField.getText();
            double precioBase = Double.parseDouble(precioField.getText());
            EstadoObraDeArte estado = EstadoObraDeArte.valueOf((String) estadoComboBox.getSelectedItem());
            String descripcion = descripcionField.getText();
            ObraDeArte nuevaObra;

            String tipoObra = (String) tipoObraComboBox.getSelectedItem();
            switch (tipoObra) {
                case "Escultura":
                    nuevaObra = new TipoEscultura(id, titulo, artista, anio, lugar, propietarioId, precioBase, estado, 0, 0, 0, "", 0, false, descripcion);
                    break;
                case "Imagen":
                    nuevaObra = new TipoImagen(id, titulo, artista, anio, lugar, propietarioId, precioBase, estado, "", "", descripcion);
                    break;
                case "Impresion":
                    nuevaObra = new TipoImpresion(id, titulo, artista, anio, lugar, propietarioId, precioBase, estado, "", "", descripcion);
                    break;
                case "Pintura":
                    nuevaObra = new TipoPintura(id, titulo, artista, anio, lugar, propietarioId, precioBase, estado, 0, 0, "", descripcion);
                    break;
                case "Video":
                    nuevaObra = new TipoVideo(id, titulo, artista, anio, lugar, propietarioId, precioBase, estado, 0, "", "", descripcion);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de obra desconocido: " + tipoObra);
            }

            if (obraExistente == null) {
                inventario.agregarObra(nuevaObra);
            } else {
                inventario.actualizarObra(id, nuevaObra);
            }

            JOptionPane.showMessageDialog(this, "Obra guardada con éxito!");
            setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la obra: " + ex.getMessage());
        }
    }
}

