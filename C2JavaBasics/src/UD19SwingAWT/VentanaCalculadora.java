package UD19SwingAWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        setUndecorated(true);
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Barra de menú
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

        // Mostrar historial desde la base de datos
        itemHistorial.addActionListener(e -> {
            DefaultListModel<String> modeloDesdeBD = HistorialBD.obtenerHistorial();
            listaHistorial.setModel(modeloDesdeBD);
            JOptionPane.showMessageDialog(this, new JScrollPane(listaHistorial),
                    "Historial de cálculos", JOptionPane.INFORMATION_MESSAGE);
        });

        itemSalir.addActionListener(e -> System.exit(0));

        menuOpciones.add(itemTemaClaro);
        menuOpciones.add(itemTemaOscuro);
        menuOpciones.add(itemTemaNeon);
        menuOpciones.add(itemHistorial);
        menuOpciones.add(itemSalir);

        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);

        // **Añadir pronunciación de menú**
        MouseAdapter pronunciarOpciones = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JMenuItem item = (JMenuItem) e.getSource();
                EspeakTTS.hablar(item.getText());  // ✅ Pronunciar opción del menú
            }
        };
        
        // Añadir MouseListener para el menú principal
        menuOpciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EspeakTTS.hablar("Opciones");  // ✅ Pronuncia el nombre del menú
            }
        });


        // Aplicar pronunciación a cada opción del menú
        itemTemaClaro.addMouseListener(pronunciarOpciones);
        itemTemaOscuro.addMouseListener(pronunciarOpciones);
        itemTemaNeon.addMouseListener(pronunciarOpciones);
        itemHistorial.addMouseListener(pronunciarOpciones);
        itemSalir.addMouseListener(pronunciarOpciones);

        // Área de resultados
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
        panelCampos.add(campoOperador, BorderLayout.NORTH);
        panelCampos.add(campoResultado, BorderLayout.CENTER);
        panelCampos.setPreferredSize(new Dimension(400, 90));

        add(panelCampos, BorderLayout.NORTH);

        // Panel de botones
        panelBotones = new PanelBotones(campoOperador, campoResultado, modeloHistorial);
        add(panelBotones, BorderLayout.CENTER);

        // Cargar historial desde la base de datos al iniciar
        modeloHistorial = HistorialBD.obtenerHistorial();
        listaHistorial.setModel(modeloHistorial);

        cambiarTema(Tema.CLARO);
        pack();
        setMinimumSize(new Dimension(400, 500));

        // Movimiento de ventana sin bordes
        Point mouseClickPoint = new Point();
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseClickPoint.setLocation(e.getPoint());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currentScreenLocation = e.getLocationOnScreen();
                setLocation(currentScreenLocation.x - mouseClickPoint.x, currentScreenLocation.y - mouseClickPoint.y);
            }
        });
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
                fondo = new Color(30, 30, 40); // Negro azulado
                texto = new Color(180, 0, 255); // Morado neón
                botones = new Color(30, 30, 40); // Mismo color del fondo, con borde marcado
                bordes = new Color(100, 255, 255); // Borde neón fino
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