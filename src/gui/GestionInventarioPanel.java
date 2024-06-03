package gui;

import gestion.Inventario;
import obraDeArte.ObraDeArte;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class GestionInventarioPanel extends JPanel {
    private MainFrame mainFrame;
    private Inventario inventario;
    private DefaultTableModel tableModel;

    public GestionInventarioPanel(MainFrame mainFrame, Inventario inventario) {
        this.mainFrame = mainFrame;
        this.inventario = inventario;
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"ID", "Título", "Artista", "Año", "Lugar de Creación"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton agregarButton = new JButton("Agregar Obra");
        agregarButton.addActionListener(e -> mainFrame.showPanel("AgregarObra"));
        buttonPanel.add(agregarButton);

        JButton eliminarButton = new JButton("Eliminar Obra");
        eliminarButton.addActionListener(e -> eliminarObra(table.getSelectedRow()));
        buttonPanel.add(eliminarButton);

        add(buttonPanel, BorderLayout.SOUTH);

        cargarObras();
    }

    private void cargarObras() {
        tableModel.setRowCount(0);
        List<ObraDeArte> obras = inventario.consultarObras();
        for (ObraDeArte obra : obras) {
            tableModel.addRow(new Object[]{obra.getId(), obra.getTitulo(), obra.getArtista(), obra.getAnio(), obra.getLugarCreacion()});
        }
    }

    private void eliminarObra(int selectedRow) {
        if (selectedRow >= 0) {
            String id = (String) tableModel.getValueAt(selectedRow, 0);
            inventario.eliminarObra(id);
            cargarObras();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una obra para eliminar.");
        }
    }
}

