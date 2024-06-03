package gui;

import gestion.Inventario;
import gestion.Subasta;
import obraDeArte.ObraDeArte;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class AgregarSubastaDialog extends JDialog {
    private Inventario inventario;
    private JTextField idField;
    private JTextField obraIdField;
    private JTextField valorInicialField;
    private JTextField valorMinimoField;
    private JTextField fechaInicioField;
    private JTextField fechaFinField;

    public AgregarSubastaDialog(Frame owner, Inventario inventario) {
        super(owner, "Agregar Subasta", true);
        this.inventario = inventario;
        setLayout(new GridLayout(7, 2));

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("ID Obra:"));
        obraIdField = new JTextField();
        add(obraIdField);

        add(new JLabel("Valor Inicial:"));
        valorInicialField = new JTextField();
        add(valorInicialField);

        add(new JLabel("Valor Mínimo:"));
        valorMinimoField = new JTextField();
        add(valorMinimoField);

        add(new JLabel("Fecha Inicio (yyyy-MM-ddTHH:mm):"));
        fechaInicioField = new JTextField();
        add(fechaInicioField);

        add(new JLabel("Fecha Fin (yyyy-MM-ddTHH:mm):"));
        fechaFinField = new JTextField();
        add(fechaFinField);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(e -> agregarSubasta());
        add(agregarButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e -> dispose());
        add(cancelarButton);

        pack();
        setLocationRelativeTo(owner);
    }

    private void agregarSubasta() {
        try {
            String id = idField.getText();
            String obraId = obraIdField.getText();
            double valorInicial = Double.parseDouble(valorInicialField.getText());
            double valorMinimo = Double.parseDouble(valorMinimoField.getText());
            LocalDateTime fechaInicio = LocalDateTime.parse(fechaInicioField.getText());
            LocalDateTime fechaFin = LocalDateTime.parse(fechaFinField.getText());

            ObraDeArte obra = inventario.consultarObras().stream().filter(o -> o.getId().equals(obraId)).findFirst().orElse(null);
            if (obra != null) {
                Subasta nuevaSubasta = new Subasta(id, obra, fechaInicio, fechaFin, valorInicial, valorMinimo);
                inventario.agregarSubasta(nuevaSubasta);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "ID de obra no válido.");
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.");
        }
    }
}

