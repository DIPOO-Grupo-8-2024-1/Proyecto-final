package gui;

import gestion.Inventario;
import usuario.Usuario;

import javax.swing.*;
import java.awt.*;

public class AutenticacionPanel extends JPanel {
    private MainFrame mainFrame;
    private Inventario inventario;
    private JTextField emailField;
    private JPasswordField passwordField;

    public AutenticacionPanel(MainFrame mainFrame, Inventario inventario) {
        this.mainFrame = mainFrame;
        this.inventario = inventario;
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> autenticarUsuario());
        add(loginButton);
    }

    private void autenticarUsuario() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        Usuario usuario = inventario.autenticarUsuario(email, password);

        if (usuario != null) {
            mainFrame.setUsuarioActual(usuario);
            mainFrame.mostrarPanelUsuario(usuario);
        } else {
            JOptionPane.showMessageDialog(this, "Email o contraseña incorrectos.");
        }
    }
}
