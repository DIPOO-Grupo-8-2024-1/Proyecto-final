package gui;

import gestion.Inventario;
import usuario.Comprador;

import javax.swing.*;
import java.awt.*;

public class CompradorPanel extends JPanel {
    private Comprador comprador;
    private Inventario inventario;

    public CompradorPanel(Comprador comprador, Inventario inventario) {
        this.comprador = comprador;
        this.inventario = inventario;
        setLayout(new BorderLayout());

        // Ejemplo de botones para las funcionalidades del comprador
        JButton verObrasDisponiblesButton = new JButton("Ver Obras Disponibles");
        verObrasDisponiblesButton.addActionListener(e -> verObrasDisponibles());
        add(verObrasDisponiblesButton, BorderLayout.NORTH);

        JButton verHistorialComprasButton = new JButton("Ver Historial de Compras");
        verHistorialComprasButton.addActionListener(e -> verHistorialCompras());
        add(verHistorialComprasButton, BorderLayout.CENTER);
    }

    private void verObrasDisponibles() {
        // Lógica para ver obras disponibles para comprar
    }

    private void verHistorialCompras() {
        // Lógica para ver el historial de compras
    }
}
