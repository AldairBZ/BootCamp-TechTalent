package UD19SwingAWT;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCalculadora extends JFrame {

    // ✅ Variables principales
    private JTextField campoOperador;
    private JTextField campoResultado;
    private PanelBotones panelBotones;
    private DefaultListModel<String> modeloHistorial = new DefaultListModel<>();
    private JList<String> listaHistorial = new JList<>(modeloHistorial);
    
    public static boolean audioActivado = true; // ✅ Controla el audio en botones y cálculos

    // ✅ Enumeración para los temas de la calculadora
    public enum Tema {
        CLARO, OSCURO, NEON
    }

    // ✅ Constructor - Inicializa la ventana y los componentes
    public VentanaCalculadora() {
        configurarVentana();
        inicializarInterfazGrafica();
        configurarMenu();
        configurarPronunciacionMenu();
    }

    // ✅ Configuración de la ventana principal
    private void configurarVentana() {
        setUndecorated(true);
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    // ✅ Inicializar los componentes gráficos
    private void inicializarInterfazGrafica() {
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
    }

    // ✅ Configurar el menú y sus opciones
    private void configurarMenu() {
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

        // ✅ Nueva opción de Audio Descriptivo
        JCheckBoxMenuItem itemAudioDescriptivo = new JCheckBoxMenuItem("Audio Descriptivo");
        itemAudioDescriptivo.setSelected(true);  // ✅ Activado por defecto
        
        itemAudioDescriptivo.addActionListener(e -> {
            audioActivado = itemAudioDescriptivo.isSelected();  
            System.out.println("🔊 Audio de botones/resultados: " + (audioActivado ? "Activado" : "Desactivado"));
        });

        // ✅ Pronunciación para la opción de audio
        itemAudioDescriptivo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EspeakTTS.hablar("Audio Descriptivo, activado o desactivado");
            }
        });

        // ✅ Mostrar historial desde la base de datos
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
        menuOpciones.add(itemAudioDescriptivo);
        menuOpciones.add(itemSalir);

        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);
    }

    // ✅ Configurar la pronunciación de opciones en el menú
    private void configurarPronunciacionMenu() {
        MouseAdapter pronunciarOpciones = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JMenuItem item = (JMenuItem) e.getSource();
                EspeakTTS.hablar(item.getText());
            }
        };
        
        JMenu menuOpciones = getJMenuBar().getMenu(0);
        menuOpciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EspeakTTS.hablar("Opciones");
            }
        });

        for (Component item : menuOpciones.getMenuComponents()) {
            if (item instanceof JMenuItem) {
                item.addMouseListener(pronunciarOpciones);
            }
        }
    }

    // ✅ Método para cambiar el tema de la calculadora
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
                fondo = new Color(30, 30, 40); 
                texto = new Color(180, 0, 255); 
                botones = new Color(30, 30, 40);
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