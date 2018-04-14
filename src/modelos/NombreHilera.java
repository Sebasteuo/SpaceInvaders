package modelos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * @author sebastianalba
 *
 */

public class NombreHilera extends Coordenada implements Dibujable {

	String hilera;
	Color color;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param r
	 * @param lista
	 * @param col
	 */
	public NombreHilera(float x, float y, int r, String lista, Color col) {
		super(x, y);
		color = col;
		hilera = lista;
	}

	/**
	 *  Dibuja los datos importantes como estadisticas e hileras 
	 */
	@Override
	public void dibujar(Graphics g) {

		int fontSize = 15;
		g.setFont(new Font("Chalkduster", Font.PLAIN, fontSize));// Bradley Hand-HERCULANUM
		g.setColor(color);
		g.drawString(hilera, (int) this.getX(), (int) this.getY());
	}

}