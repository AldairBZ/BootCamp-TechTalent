package UD19SwingAWT;

import javax.swing.*;
import java.awt.*;

public class VentanaCalculadora extends JFrame {

    private JTextField campoOperador;
    private JTextField campoResultado;
    private PanelBotones panelBotones;
    private DefaultListModel<String> modeloHistorial = new DefaultListModel<>();
    private JList<String> listaHistorial = new JList<>(modeloHistorial);

    public enum Tema {
        CLARO, OSCURO, NEON
    }

    public VentanaCalculadora() {
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");

        JMenuItem itemTemaClaro = new JMenuItem("Tema Claro");
        JMenuItem itemTemaOscuro = new JMenuItem("Tema Oscuro");
        JMenuItem itemTemaNeon = new JMenuItem("Tema Neón");
        JMenuItem itemHistorial = new JMenuItem("Historial");
        JMenuItem itemSalir = new JMenuItem("Salir");

        itemTemaClaro.addActionListener(e -> cambiarTema(Tema.CLARO));
        itemTemaOscuro.addActionListener(e -> cambiarTema(Tema.OSCURO));
        itemTemaNeon.addActionListener(e -> cambiarTema(Tema.NEON));
        itemHistorial.addActionListener(e -> JOptionPane.showMessageDialog(this, new JScrollPane(listaHistorial),
                "Historial de cálculos", JOptionPane.INFORMATION_MESSAGE));
        itemSalir.addActionListener(e -> System.exit(0));

        menuOpciones.add(itemTemaClaro);
        menuOpciones.add(itemTemaOscuro);
        menuOpciones.add(itemTemaNeon);
        menuOpciones.add(itemHistorial);
        menuOpciones.add(itemSalir);

        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);

        campoOperador = new JTextField();
        campoOperador.setEditable(false);
        campoOperador.setFont(new Font("Consolas", Font.BOLD, 16));
        campoOperador.setHorizontalAlignment(SwingConstants.LEFT);
        campoOperador.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        campoResultado = new JTextField();
        campoResultado.setEditable(false);
        campoResultado.setFont(new Font("Consolas", Font.BOLD, 30));
        campoResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        campoResultado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelCampos = new JPanel(new BorderLayout());
        panelCampos.add(campoOperador, BorderLayout.WEST);
        panelCampos.add(campoResultado, BorderLayout.CENTER);
        panelCampos.setPreferredSize(new Dimension(400, 70));

        add(panelCampos, BorderLayout.NORTH);

        panelBotones = new PanelBotones(campoOperador, campoResultado, modeloHistorial);
        add(panelBotones, BorderLayout.CENTER);

        cambiarTema(Tema.CLARO);
    }

    private void cambiarTema(Tema tema) {
        Color fondo, texto, botones, bordes;

        switch (tema) {
            case CLARO:
                fondo = Color.WHITE;
                texto = Color.BLACK;
                botones = new Color(220, 220, 220);
                bordes = Color.GRAY;
                break;
            case OSCURO:
                fondo = Color.DARK_GRAY;
                texto = Color.WHITE;
                botones = new Color(80, 80, 80);
                bordes = Color.LIGHT_GRAY;
                break;
            case NEON:
                fondo = new Color(20, 20, 30);
                texto = new Color(180, 0, 255);     // Morado neón
                botones = new Color(0, 255, 255);   // Cian brillante
                bordes = new Color(100, 255, 255);
                break;
            default:
                fondo = Color.WHITE;
                texto = Color.BLACK;
                botones = new Color(220, 220, 220);
                bordes = Color.GRAY;
        }

        campoOperador.setBackground(fondo);
        campoOperador.setForeground(texto);
        campoResultado.setBackground(fondo);
        campoResultado.setForeground(texto);

        panelBotones.cambiarTema(fondo, texto, botones, bordes);

        SwingUtilities.updateComponentTreeUI(this);
    }
}
