package gui;

import gestion.Inventario;
import obraDeArte.ObraDeArte;
import obraDeArte.TipoPintura;
import obraDeArte.EstadoObraDeArte;

import javax.swing.*;
import java.awt.*;

public class AgregarObraPanel extends JPanel {
    private MainFrame mainFrame;
    private Inventario inventario;
    private JTextField idField;
    private JTextField tituloField;
    private JTextField artistaField;
    private JTextField anioField;
    private JTextField lugarCreacionField;
    private JTextField propietarioIdField;
    private JTextField precioBaseField;
    private JTextField altoField;
    private JTextField anchoField;
    private JTextField tecnicaField;
    private JTextField descripcionField;

    public AgregarObraPanel(MainFrame mainFrame, Inventario inventario) {
        this.mainFrame = mainFrame;
        this.inventario = inventario;
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(11, 2));

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
        lugarCreacionField = new JTextField();
        formPanel.add(lugarCreacionField);

        formPanel.add(new JLabel("Propietario ID:"));
        propietarioIdField = new JTextField();
        formPanel.add(propietarioIdField);

        formPanel.add(new JLabel("Precio Base:"));
        precioBaseField = new JTextField();
        formPanel.add(precioBaseField);

        formPanel.add(new JLabel("Alto:"));
        altoField = new JTextField();
        formPanel.add(altoField);

        formPanel.add(new JLabel("Ancho:"));
        anchoField = new JTextField();
        formPanel.add(anchoField);

        formPanel.add(new JLabel("Técnica:"));
        tecnicaField = new JTextField();
        formPanel.add(tecnicaField);

        formPanel.add(new JLabel("Descripción:"));
        descripcionField = new JTextField();
        formPanel.add(descripcionField);

        add(formPanel, BorderLayout.CENTER);

        JButton agregarButton = new JButton("Agregar Obra");
        agregarButton.addActionListener(e -> agregarObra());
        add(agregarButton, BorderLayout.SOUTH);
    }

    private void agregarObra() {
        try {
            String id = idField.getText();
            String titulo = tituloField.getText();
            String artista = artistaField.getText();
            int anio = Integer.parseInt(anioField.getText());
            String lugarCreacion = lugarCreacionField.getText();
            String propietarioId = propietarioIdField.getText();
            double precioBase = Double.parseDouble(precioBaseField.getText());
            double alto = Double.parseDouble(altoField.getText());
            double ancho = Double.parseDouble(anchoField.getText());
            String tecnica = tecnicaField.getText();
            String descripcion = descripcionField.getText();

            ObraDeArte nuevaObra = new TipoPintura(id, titulo, artista, anio, lugarCreacion, propietarioId, precioBase, EstadoObraDeArte.DISPONIBLE, ancho, alto, tecnica, descripcion);
            inventario.agregarObra(nuevaObra);
            mainFrame.showPanel("Inventario");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.");
        }
    }
}

