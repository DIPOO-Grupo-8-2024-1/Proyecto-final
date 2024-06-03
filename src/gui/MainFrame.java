package gui;

import gestion.Inventario;
import usuario.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Inventario inventario;
    private Usuario usuarioActual;

    public MainFrame() {
        inventario = new Inventario("datos");

        setTitle("Galería y Casa de Subastas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new AutenticacionPanel(this, inventario), "Autenticacion");

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        mostrarPanel("Autenticacion");
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    public void mostrarPanelUsuario(Usuario usuario) {
        if (usuario instanceof Administrador) {
            mainPanel.add(new AdministradorPanel((Administrador) usuario, inventario), "Administrador");
            mostrarPanel("Administrador");
        } else if (usuario instanceof Comprador) {
            mainPanel.add(new CompradorPanel((Comprador) usuario, inventario), "Comprador");
            mostrarPanel("Comprador");
        } else if (usuario instanceof Empleado) {
            mainPanel.add(new EmpleadoPanel((Empleado) usuario, inventario), "Empleado");
            mostrarPanel("Empleado");
        } else if (usuario instanceof Propietario) {
            mainPanel.add(new PropietarioPanel((Propietario) usuario, inventario), "Propietario");
            mostrarPanel("Propietario");
        } else if (usuario instanceof PropietarioComprador) {
            mainPanel.add(new PropietarioCompradorPanel((PropietarioComprador) usuario, inventario), "PropietarioComprador");
            mostrarPanel("PropietarioComprador");
        }
    }

    public void mostrarPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}







