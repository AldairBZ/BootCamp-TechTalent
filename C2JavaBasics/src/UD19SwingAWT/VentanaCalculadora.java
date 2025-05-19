package UD19SwingAWT;
import javax.swing.*;
import java.awt.*;

public class VentanaCalculadora extends JFrame{
	
	private JTextField campoResultado;
	
	public VentanaCalculadora() {
		setTitle("Calculadora");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //centrada
		setLayout(new BorderLayout());
		setResizable(true); //Se puede redimensionar
		
		
		//Crear campo de texto solo lectura
		CampoResultado= new JTextField();
		CampoResultado.setEditable(false); //solo lectura
		CampoResultado.setFont(new Font("Consolas", Font.BOLD, 30));
		CampoResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		CampoResultado.setBackground(color.WHITE);
		CampoResultado.setPreferredSize(new Dimension (400, 70));
		
		
		//Agregar a la parte de arriba
		add(campoResultado, BorderLayout.NORTH);
	}
}
