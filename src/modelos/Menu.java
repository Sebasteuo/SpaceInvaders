package modelos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author sebastianalba
 *
 */
public class Menu extends JPanel {
	public Menu() {
		this.setBackground(Color.red);
	}

	/**
	 *Esta funcion se encarga de iniciar todas las animaciones y movimientos de juego, asi como los disparos y la destrucción de los enemigos, tambien verificar si se acaba el juego inclusive.     
	 */
	public void iniciar() {
		JLabel a = new JLabel("Nuevo Juego");
		JLabel b = new JLabel("Estadisticas");
		this.add(a);
		this.add(b);

	}
}
