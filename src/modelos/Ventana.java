package modelos;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

/**
 * 
 * @author sebastianalba
 *
 */
public class Ventana extends javax.swing.JFrame implements WindowListener {
	/**
	 * 
	 * @param titulo
	 */
	public Ventana(String titulo) {
		super(titulo);
		this.addWindowListener(this);
		JPanel panel2, panel3;
		panel2 = new JPanel(new FlowLayout());
		panel2.setBackground(Color.BLACK);
		panel2.setPreferredSize(new Dimension(90, 40));

		panel3 = new JPanel(new FlowLayout());
		panel3.setBackground(Color.BLACK);
		panel3.setPreferredSize(new Dimension(90, 40));
		setLayout(new CardLayout());

		JLabel l = new JLabel(" ");
		String path = "/imagenes/juego1.jpg";
		URL url = this.getClass().getResource(path);
		ImageIcon icon = new ImageIcon(url);
		l.setIcon(icon);

		JButton a = new JButton("Ver estadisticas");
		JButton b = new JButton("Jugar");
		JPanel contenedor = new JPanel();
		PanelJuego panel = new PanelJuego();
		CardLayout c = new CardLayout();

		ArrayList<String> puntaje = this.CargarEstadisticas();
		// JLabel estad=new JLabel("Estadisticas");
		// estad.setFont(new java.awt.Font("Arial", 0, 20));
		// panel2.add(estad);

		panel.setLayout(null);

		JButton volver = new JButton("Volver");
		panel2.add(volver);

		JList lista = new JList();
		DefaultListModel modelo = new DefaultListModel();
		for (int i = 0; i < puntaje.size(); i++) {
			modelo.addElement(puntaje.get(i));
		}
		lista.setModel(modelo);
		lista.setBackground(Color.GRAY);
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		Object[] seleccion = lista.getSelectedValues();
		int[] indices = lista.getSelectedIndices();
		JScrollPane barraDesplazamiento = new JScrollPane(lista);
		barraDesplazamiento.setBounds(10, 30, 200, 110);
		panel2.add(barraDesplazamiento);

		contenedor.setLayout(c);
		panel3.add(l);
		panel3.add(a);
		panel3.add(b);
		b.setBackground(Color.GRAY);
		a.setBackground(Color.GRAY);

		contenedor.add(panel3, "1");
		contenedor.add(panel, "2");
		contenedor.add(panel2, "3");
		c.show(contenedor, "1");

		////////////////////////////////////// SE AGREGA PANEL A LA VENTANA
		/**
		 *     
		 */
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.nombreJug = JOptionPane.showInputDialog("Digite su nombre:");
				panel.crearComponentesJuego();
				c.show(contenedor, "2");
			}
		});

		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(contenedor, "3");

				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						c.show(contenedor, "1");
					}
				});
			}
		});

		add(contenedor);
		pack();
		setSize(700, 500);
		setVisible(true);

		setBackground(Color.BLACK);
		panel.iniciar();
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> CargarEstadisticas() {
		// Creamos un String que va a contener todo el texto del archivo
		String texto = "";
		ArrayList<String> puntaje = new ArrayList<String>();
		try {
			FileReader lector = new FileReader("estadisticas.txt");
			BufferedReader contenido = new BufferedReader(lector);
			while ((texto = contenido.readLine()) != null) {
				puntaje.add(texto);
			}
		} catch (Exception e) {
			System.out.println("Error al leer");
		}
		return puntaje;
	}

	/**
	 *     
	 */
	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}