
package modelos;

/**
 * 
 * @author sebastianalba
 *
 */

public class Coordenada {
	private float x;
	private float y;

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Coordenada(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param x
	 */

	public void setX(float x) {
		this.x = x;
	}

	/**
	 * 
	 * @param y
	 */

	public void setY(float y) {
		this.y = y;
	}

	/**
	 * 
	 * @return
	 */

	public float getX() {
		return x;
	}

	/**
	 * 
	 * @return
	 */

	public float getY() {
		return y;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */

	public Coordenada suma(Coordenada c) {
		float sumX = this.x + c.getX();
		float sumY = this.y + c.getY();

		Coordenada cor = new Coordenada(sumX, sumY);
		return cor;

	}
}