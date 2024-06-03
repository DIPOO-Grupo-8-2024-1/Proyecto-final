package gui;

import gestion.Inventario;
import gestion.Oferta;
import gestion.Subasta;
import gestion.EstadoOferta;
import gestion.EstadoSubasta;
import gestion.MetodoDePago;
import usuario.Cajero;
import usuario.Operador;
import usuario.Empleado;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EmpleadoPanel extends JPanel {
    private Empleado empleado;
    private Inventario inventario;

    public EmpleadoPanel(Empleado empleado, Inventario inventario) {
        this.empleado = empleado;
        this.inventario = inventario;
        setLayout(new BorderLayout());

        if (empleado instanceof Cajero) {
            crearPanelCajero((Cajero) empleado);
        } else if (empleado instanceof Operador) {
            crearPanelOperador((Operador) empleado);
        }
    }

    private void crearPanelCajero(Cajero cajero) {
        // Crear interfaz para las funcionalidades del cajero
        JButton registrarPagoButton = new JButton("Registrar Pago");
        registrarPagoButton.addActionListener(e -> registrarPago(cajero));
        add(registrarPagoButton, BorderLayout.NORTH);

        // Otras funcionalidades del cajero...
    }

    private void crearPanelOperador(Operador operador) {
        // Crear interfaz para las funcionalidades del operador
        JButton registrarOfertaButton = new JButton("Registrar Oferta");
        registrarOfertaButton.addActionListener(e -> registrarOferta(operador));
        add(registrarOfertaButton, BorderLayout.NORTH);

        // Otras funcionalidades del operador...
    }

    private void registrarPago(Cajero cajero) {
        // Lógica para registrar pago
        String ofertaId = JOptionPane.showInputDialog(this, "Ingrese el ID de la oferta aprobada:");
        Oferta oferta = inventario.consultarOfertas().stream().filter(o -> o.getId().equals(ofertaId)).findFirst().orElse(null);

        if (oferta != null && oferta.getEstado() == EstadoOferta.APROBADA) {
            MetodoDePago[] metodosDePago = MetodoDePago.values();
            MetodoDePago metodoSeleccionado = (MetodoDePago) JOptionPane.showInputDialog(this, "Seleccione el método de pago:",
                    "Método de Pago", JOptionPane.QUESTION_MESSAGE, null, metodosDePago, metodosDePago[0]);

            if (metodoSeleccionado != null) {
                cajero.registrarPago(oferta, metodoSeleccionado, inventario);
                JOptionPane.showMessageDialog(this, "Pago registrado con éxito.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Oferta no válida o no aprobada.");
        }
    }

    private void registrarOferta(Operador operador) {
        // Lógica para registrar oferta
        String subastaId = JOptionPane.showInputDialog(this, "Ingrese el ID de la subasta:");
        Subasta subasta = inventario.consultarSubastas().stream().filter(s -> s.getId().equals(subastaId)).findFirst().orElse(null);

        if (subasta != null && subasta.getEstado() == EstadoSubasta.EN_PROGRESO) {
            String ofertaId = "oferta_" + (subasta.getOfertas().size() + 1);
            String idComprador = JOptionPane.showInputDialog(this, "Ingrese el ID del comprador:");
            double valorOfrecido = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese el valor ofrecido:"));

            Oferta nuevaOferta = new Oferta(ofertaId, idComprador, valorOfrecido, LocalDateTime.now(), EstadoOferta.PENDIENTE, subasta.getObra());
            operador.registrarOferta(subasta, nuevaOferta);
            JOptionPane.showMessageDialog(this, "Oferta registrada con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Subasta no válida o no está en proceso.");
        }
    }
}


