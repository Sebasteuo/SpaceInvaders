
package modelos;

/**
 * Esta clase recibe dos atributos X y Y, X y Y lo que hacen es la oposicon X del objeto y Y del objeto
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
	 * Se usa cuando se quiere mover la nave a la derecha o a la izquierda, porque modifica el X y Y, si se mueve a la izquierda se resta si se va a la derecha, se suma
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