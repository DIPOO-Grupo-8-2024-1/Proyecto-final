package gui;

import gestion.Inventario;
import gestion.Oferta;
import gestion.Subasta;
import gestion.Pago;
import gestion.MetodoDePago;
import gestion.EstadoPago;
import gestion.EstadoOferta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class SubastaCompraPanel extends JPanel {
    private MainFrame mainFrame;
    private Inventario inventario;
    private DefaultTableModel subastaTableModel;
    private DefaultTableModel compraTableModel;
    private JTable subastaTable;
    private JTable compraTable;

    public SubastaCompraPanel(MainFrame mainFrame, Inventario inventario) {
        this.mainFrame = mainFrame;
        this.inventario = inventario;
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel subastaPanel = new JPanel(new BorderLayout());
        subastaTableModel = new DefaultTableModel(new Object[]{"ID", "Obra", "Valor Inicial", "Valor Minimo", "Fecha Inicio", "Fecha Fin"}, 0);
        subastaTable = new JTable(subastaTableModel);
        subastaPanel.add(new JScrollPane(subastaTable), BorderLayout.CENTER);

        JButton agregarSubastaButton = new JButton("Agregar Subasta");
        agregarSubastaButton.addActionListener(e -> agregarSubasta());
        subastaPanel.add(agregarSubastaButton, BorderLayout.SOUTH);
        tabbedPane.addTab("Subastas", subastaPanel);

        JPanel compraPanel = new JPanel(new BorderLayout());
        compraTableModel = new DefaultTableModel(new Object[]{"ID", "Obra", "Comprador", "Estado"}, 0);
        compraTable = new JTable(compraTableModel);
        compraPanel.add(new JScrollPane(compraTable), BorderLayout.CENTER);

        JButton procesarCompraButton = new JButton("Procesar Compra");
        procesarCompraButton.addActionListener(e -> procesarCompra());
        compraPanel.add(procesarCompraButton, BorderLayout.SOUTH);
        tabbedPane.addTab("Compras", compraPanel);

        add(tabbedPane, BorderLayout.CENTER);

        cargarSubastas();
        cargarCompras();
    }

    private void agregarSubasta() {
        new AgregarSubastaDialog(mainFrame, inventario).setVisible(true);
        cargarSubastas();
    }

    private void procesarCompra() {
        int selectedRow = compraTable.getSelectedRow();
        if (selectedRow >= 0) {
            String id = (String) compraTableModel.getValueAt(selectedRow, 0);
            Oferta oferta = inventario.consultarOfertas().stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
            if (oferta != null) {
                // Procesar la oferta
                if (oferta.getEstado() == EstadoOferta.PENDIENTE) {
                    Pago nuevoPago = new Pago(
                            oferta.getId(), oferta.getIdComprador(), oferta.getValorOfrecido(),
                            LocalDateTime.now(), MetodoDePago.TARJETA_CREDITO, EstadoPago.PENDIENTE
                    );
                    if (nuevoPago.procesarCompra(inventario)) {
                        oferta.setEstado(EstadoOferta.APROBADA);
                        JOptionPane.showMessageDialog(mainFrame, "Compra procesada con éxito!");
                    } else {
                        oferta.setEstado(EstadoOferta.RECHAZADA);
                        JOptionPane.showMessageDialog(mainFrame, "Error al procesar la compra: Verifique los datos del comprador.");
                    }
                    cargarCompras();
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "La oferta ya ha sido procesada.");
                }
            }
        }
    }

    private void cargarSubastas() {
        subastaTableModel.setRowCount(0);
        List<Subasta> subastas = inventario.consultarSubastas();
        for (Subasta subasta : subastas) {
            subastaTableModel.addRow(new Object[]{
                    subasta.getId(), subasta.getObra().getTitulo(),
                    subasta.getValorInicial(), subasta.getValorMinimo(),
                    subasta.getFechaInicio(), subasta.getFechaFin()
            });
        }
    }

    private void cargarCompras() {
        compraTableModel.setRowCount(0);
        List<Oferta> ofertas = inventario.consultarOfertas();
        for (Oferta oferta : ofertas) {
            compraTableModel.addRow(new Object[]{
                    oferta.getId(), oferta.getObra().getTitulo(), oferta.getIdComprador(), oferta.getEstado().getEstadoOferta()
            });
        }
    }
}





