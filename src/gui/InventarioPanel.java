package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import obraDeArte.ObraDeArte;

import java.awt.*;
import java.util.List;

public class InventarioPanel extends JPanel {
    private MainFrame mainFrame;
    private DefaultTableModel tableModel;

    public InventarioPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Inventario de Obras de Arte");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Título", "Artista", "Año", "Precio Base", "Estado"}, 0);
        JTable inventarioTable = new JTable(tableModel);
        add(new JScrollPane(inventarioTable), BorderLayout.CENTER);

        JButton refrescarButton = new JButton("Refrescar Inventario");
        refrescarButton.addActionListener(e -> cargarInventario());
        add(refrescarButton, BorderLayout.SOUTH);

        cargarInventario();
    }

    private void cargarInventario() {
        try {
            List<ObraDeArte> obras = mainFrame.getPersistencia().cargarObras();
            tableModel.setRowCount(0);
            for (ObraDeArte obra : obras) {
                tableModel.addRow(new Object[]{
                        obra.getId(), obra.getTitulo(), obra.getArtista(),
                        obra.getAnio(), obra.getPrecioBase(), obra.getEstado()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame, "Error al cargar el inventario: " + e.getMessage());
        }
    }
}


