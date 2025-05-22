package UD19SwingAWT;
import javax.swing.*;
import java.awt.*;

public class VentanaCalculadora extends JFrame {

    private JTextField campoResultado;

    public VentanaCalculadora() {
        setTitle("Calculadora"); //titulo
        setSize(400, 500); //Medidas de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierre de ventana por defecto
        setLocationRelativeTo(null); // Centra la pantalla
        setLayout(new BorderLayout()); //Organiza en zona
        setResizable(true); // ✅ Se puede redimensionar

        // Crear campo de texto solo lectura
        campoResultado = new JTextField();
        campoResultado.setEditable(false); // Solo lectura
        campoResultado.setFont(new Font("Consolas", Font.BOLD, 30));
        campoResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        campoResultado.setBackground(Color.WHITE);
        campoResultado.setPreferredSize(new Dimension(400, 70));

        // Agregar a la parte de arriba
        add(campoResultado, BorderLayout.NORTH);

        // Panel de botones
        PanelBotones panel = new PanelBotones(campoResultado);
        add(panel, BorderLayout.CENTER);
    }
}
