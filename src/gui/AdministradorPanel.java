package gui;

import gestion.Inventario;
import usuario.Administrador;

import javax.swing.*;
import java.awt.*;

public class AdministradorPanel extends JPanel {
    private Administrador administrador;
    private Inventario inventario;

    public AdministradorPanel(Administrador administrador, Inventario inventario) {
        this.administrador = administrador;
        this.inventario = inventario;
        setLayout(new BorderLayout());

        // Ejemplo de botones para las funcionalidades del administrador
        JButton gestionarUsuariosButton = new JButton("Gestionar Usuarios");
        gestionarUsuariosButton.addActionListener(e -> gestionarUsuarios());
        add(gestionarUsuariosButton, BorderLayout.NORTH);

        JButton gestionarObrasButton = new JButton("Gestionar Obras");
        gestionarObrasButton.addActionListener(e -> gestionarObras());
        add(gestionarObrasButton, BorderLayout.CENTER);
    }

    private void gestionarUsuarios() {
        // Lógica para gestionar usuarios
    }

    private void gestionarObras() {
        // Lógica para gestionar obras de arte
    }
}
