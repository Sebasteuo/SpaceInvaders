
package modelos;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author sebastianalba
 *
 */
public class Bala extends Coordenada implements Dibujable {

	private float radio;
	private Color color;

	public Bala(Coordenada cor, float r, Color c) {
		super(cor.getX(), cor.getY());
		radio = r;
		color = c;
	}

	/**
	 * Dibuja las balas
	 */
	@Override
	public void dibujar(Graphics g) {
		g.setColor(color);
		// g.fillOval((int)(this.getX()-radio),(int)(this.getY()-radio),(int)radio*2,(int)radio*2);
		g.fillRect((int) this.getX(), (int) this.getY(), 10, 30);
		g.setColor(Color.ORANGE);
		g.drawRect((int) this.getX(), (int) this.getY(), 10, 30);
	}

	/**
	 *Basicamente lo que hacen es darle movimiento a las balas cuando se disparan.      
	 */
	public void ciclo() {
		float x = this.getY();
		this.setY(x += 20);
	}

}