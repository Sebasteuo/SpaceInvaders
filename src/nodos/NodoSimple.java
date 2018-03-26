package nodos;
/**
 * 
 * @author sebastianalba
 *
 */
public class NodoSimple {
	private int valor;
	private NodoSimple siguiente;
/**
 * 	
 */
	public void NodoSimple() {
		this.valor = 0;
		this.siguiente = null;
	}
/**
 * 
 * @return
 */
	public  int getValor() {
		return valor;
	}
/**
 * 
 * @param valor
 */
	public void setValor(int valor) {
		this.valor = valor;
	}
/**
 * 
 * @return
 */
	public NodoSimple getSiguiente() {
		return siguiente;
	}
/**
 * 
 * @param siguiente
 */
	
	public void setSiguiente(NodoSimple siguiente) {
		this.siguiente = siguiente;
	}
}
