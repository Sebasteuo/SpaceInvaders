
package modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * 
 * @author sebastianalba
 *
 */
public class Nave extends Coordenada implements Dibujable {

	public Coordenada c1, c2;
	public Color color;
	public ArrayList<Bala> balas = new ArrayList<Bala>();

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param colo
	 */
	public Nave(Coordenada a, Coordenada b, Coordenada c, Color colo) {
		super(a.getX(), a.getY());
		c1 = new Coordenada(b.getX(), b.getY());
		color = Color.black;
		c2 = new Coordenada(c.getX(), c.getY());
	}

	/**
	 * 
	 * @param c
	 * @param l
	 */
	public void setVertice(Coordenada c, int l) {
		if (l == 1) {
			this.setX(c.getX());
			this.setY(c.getY());
		}
		if (l == 2) {
			c1.setX(c.getX());
			c1.setY(c.getY());
		}
		if (l == 3) {
			c2.setX(c.getX());
			c2.setY(c.getY());
		}
	}

	/**
	 * 
	 */
	@Override
	public void dibujar(Graphics g) {
		// ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/Nave.png"));
		// g.drawImage(Img.getImage(), 500, 390, 70, 70, null);

		g.setColor(color);
		int x[] = { (int) this.getX(), (int) c1.getX(), (int) c2.getX() };
		int y[] = { (int) this.getY(), (int) c1.getY(), (int) c2.getY() };
		Polygon p = new Polygon(x, y, 3);
		g.fillPolygon(p);
		ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/Nave.png"));
		g.drawImage(Img.getImage(), (int) this.getX() - 35, (int) this.getY(), 70, 70, null);
	}

	/**
	 * 
	 * @param g
	 * @param c
	 */
	public void pintar(Graphics g, Color c) {
		// ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/Nave.png"));
		// g.drawImage(Img.getImage(), 500, 390, 70, 70, null);

		g.setColor(c);
		int x[] = { (int) this.getX(), (int) c1.getX(), (int) c2.getX() };
		int y[] = { (int) this.getY(), (int) c1.getY(), (int) c2.getY() };
		Polygon p = new Polygon(x, y, 3);
		g.fillPolygon(p);

		ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/Nave.png"));
		g.drawImage(Img.getImage(), (int) this.getX() - 35, (int) this.getY(), 70, 70, null);
	}

	/**
	 * 
	 * @param c
	 */
	public void mover(Coordenada c) {
		if (c2.suma(c).getX() > 50 && c2.suma(c).getX() < 725) {
			this.setVertice(this.suma(c), 1);
			this.setVertice(c1.suma(c), 2);
			this.setVertice(c2.suma(c), 3);
		}
	}

	/**
	 * 
	 * @return
	 */
	public Bala crearBala() {
		Coordenada c = new Coordenada(this.getX(), this.getY());
		Bala bala = new Bala(c, 10, Color.YELLOW);
		return bala;
	}

	/**
	 * 
	 */
	public void ciclo() {
		for (int i = 0; i < balas.size(); i++) {
			Bala y = (Bala) this.balas.get(i);
			float x = y.getY();
			y.setY(x -= 20);
		}

	}
}