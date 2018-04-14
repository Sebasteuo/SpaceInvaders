package modelos;

import listas.*;
import nodo.Nodo;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

/**
 * 
 * @author sebastianalba
 *
 */

public class PanelJuego extends JPanel implements KeyListener {
	ArrayList elementos;// ArrayList de elementos del Panel (Invasores, nave, balas......)
	private Nave nave = null;// Nave
	private final Coordenada movIzq = new Coordenada(-25, 0);// movimiento hacia izquierda de la nave
	private final Coordenada movDer = new Coordenada(25, 0);// movimiento hacia derecha de la nave
	private ListaPadre invasores = null;// Hilera de invasores
	private int nivel = 0, contJefe = 0, puntos = 0, velocidad = 3, contDisparos = 0,
			resistencias[] = new int[this.tamañoHilera], contR = 0;
	private final String hilera[] = { "A", "B", "D", "E", "C", "Basic" };// Nombre de las hileras
	public String listaActual = "", listaSiguiente, nombreJug;
	public final int contDisparosHileraD[] = new int[5], tamañoHilera = 5;// vector que guarda disparos de cada jugador
																			// en su posicion
	private NombreHilera nh, next, nombre, puntaje, etiquetaNivel;// etiquetas
	private int cont2 = 0;

	/**
	 * 
	 */
	public PanelJuego() { // Constructor
		this.addKeyListener(this);// agrega evento al teclado
		this.setFocusable(true);
		elementos = new ArrayList();
		nave = new Nave(new Coordenada(0, 0), new Coordenada(0, 0), new Coordenada(0, 0), Color.red);
		invasores = null;
		listaSiguiente = "D";// Lista Siguiente
		next = new NombreHilera(0, 0, 0, "", Color.red);
		nh = new NombreHilera(0, 0, 0, "", Color.red);
		etiquetaNivel = new NombreHilera(0, 0, 0, "", Color.red);
		puntaje = new NombreHilera(0, 0, 0, "", Color.red);
	}

	/**
	 * 
	 */
	public void crearComponentesJuego() {
		elementos = new ArrayList();
		////////// se crea la nave
		Coordenada c = new Coordenada(525, 400);
		Coordenada c1 = new Coordenada(475, 450);
		Coordenada c2 = new Coordenada(575, 450);
		nave = new Nave(c, c1, c2, Color.red);
		elementos.add(nave);
		///////////////////////////////////////// crea hilera actual y siguiente
		///////////////////////////////////////// aleatoriamente
		listaActual = listaSiguiente;// Lista Actual
		listaSiguiente = hilera[(int) (Math.random() * (hilera.length) + 0)];// Lista Siguiente
		if (listaActual.equals("Basic")) {
			invasores = new ListaBasic();
		}
		if (listaActual.equals("A")) {
			invasores = new ListaA();
		}
		if (listaActual.equals("B")) {
			invasores = new ListaB();
		}
		if (listaActual.equals("C")) {
			invasores = new ListaC();
		}
		if (listaActual.equals("D")) {
			invasores = new ListaD();
		}
		if (listaActual.equals("E")) {
			invasores = new ListaD();
		}

		//////////////////////////////////////////// Asigna aleatoriamente un jefe a la
		//////////////////////////////////////////// hilera
		boolean hayJefe = false;// es falso porque no tenemos jeef aun
		for (int i = 1; i <= tamañoHilera; i++) {
			String j = i + "i";// Asigna id "i" al jefe pero el jefe debe tener id "j"!!!!!!!!!
			int id = (int) (Math.random() * 2);
			if (id == 0 && hayJefe == false && !listaActual.equals("Basic")) { // Si id==0 , el id es "j" Osea es el
																				// jefe
				j = i + "j";
				hayJefe = true;
			}

			if (id == 1 && !listaActual.equals("Basic")) { // si id==1 el id es "i" y NO es jefe
				j = i + "i" + "";
			}

			///////////////////////////////////////////////////////////////////// Agrega
			///////////////////////////////////////////////////////////////////// invasores
			///////////////////////////////////////////////////////////////////// a la
			///////////////////////////////////////////////////////////////////// hilera
			nh = new NombreHilera(0, 20, 40, "Hilera:" + listaActual, Color.RED);// se crea etiqueta del nombre de
																					// hilera
			elementos.add(nh); // se agrega al contenedor
			if (nh.hilera.equals("Hilera:E")) {
				Invasor inv = new Invasor(new Coordenada((i) * 100, 40), 40, Color.BLUE, j, velocidad, 0);
				invasores.insertar(inv);
				elementos.add(inv);
			}
			if (nh.hilera.equals("Hilera:D")) {
				while (true) {
					contR = 0;
					int a = (int) (Math.random() * this.tamañoHilera) + 1;
					resistencias[cont2] = a;

					for (int x = 0; x < this.tamañoHilera; x++) {
						if (a != resistencias[x]) {
							contR++;
						}
					}

					if (contR == this.tamañoHilera - 1) {
						cont2++;
						Invasor inv = new Invasor(new Coordenada((i + 2) * 100, 40), 40, Color.BLUE, j, velocidad, a);
						invasores.insertar(inv);
						elementos.add(inv);
						break;
					}

				}

			}
			if (!nh.hilera.equals("Hilera:D") && !nh.hilera.equals("Hilera:E")) { // Si hilera NO es E ni D
				Invasor inv = new Invasor(new Coordenada((i + 1) * 100, 40), 40, Color.BLUE, j, velocidad, 0);
				invasores.insertar(inv);
				elementos.add(inv);
			}
			invasores.imprimir();
			invasores.ordenarPorMayorResistencia();// ordena lista por resistencia, en caso que fuera la hilera D
			invasores.crearListaCircular();// crea lista circular , en caso que la hilera SEA CIRCULAR }
		}
		if (hayJefe == false && nh.hilera.equals("Hilera:B")) {
			invasores.raiz.info.id = 1 + "j" + "";
		} // se asigna jefe por defecto si no hay
		invasores.imprimir();
		//////////////////////////////////// ordena hilera por resistenci

		/*
		 * int n = this.tamañoHilera; float temp = 0; for(int i=0; i < n; i++){ for(int
		 * j=1; j < (n-i); j++){ if(arr[j-1] < arr[j]){ //swap elements temp = arr[j-1];
		 * arr[j-1] = arr[j]; arr[j] = temp; }
		 */

		// AUMENTO DEL NIVEL Y DE LA VELOCIDAD
		nivel++;// sube el nivel
		velocidad += 2; // aumenta la velocidad al subir de nivel
		///////////////////////////////////////////////////// CREA ETIQUETAS DE HILERA
		next = new NombreHilera(120, 20, 40, "ProxHile: " + listaSiguiente, Color.RED);
		elementos.add(next);
		etiquetaNivel = new NombreHilera(450, 20, 40, "Nivel: " + nivel, Color.RED);
		elementos.add(etiquetaNivel);
		nombre = new NombreHilera(270, 20, 40, "Nombre: " + nombreJug, Color.RED);
		elementos.add(nombre);
		puntaje = new NombreHilera(550, 20, 40, "Puntaje: " + (puntos), Color.RED);
		elementos.add(puntaje);
	}

	/**
	 * 
	 */
	@Override
	public void paint(Graphics g) {// Dibuja cada elemento del Panel , se llama solo.........
		Dimension d = getSize();
		Image im = createImage(d.width, d.height);
		Graphics buff = im.getGraphics();

		Dibujable dib;
		for (int i = 0; i < elementos.size(); i++) {
			dib = (Dibujable) elementos.get(i);
			dib.dibujar(buff);
		}
		g.drawImage(im, 0, 0, null);
	}

	/**
	 * 
	 */
	@Override
	public void update(Graphics g) {
		paint(g);
	}// actualiza pantalla.......

	/**
	 * 
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int tecla = e.getKeyCode();

		if (tecla == KeyEvent.VK_LEFT) {
			this.nave.mover(movIzq);
		}

		if (tecla == KeyEvent.VK_RIGHT) {
			this.nave.mover(movDer);
		}

		if (tecla == KeyEvent.VK_SPACE) {
			Bala bal = this.nave.crearBala();
			nave.balas.add(bal);// agrega balas a la nave
			elementos.add(bal);
		}
	}

	/**
	 * 
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_LEFT) {
			this.nave.mover(movIzq);
		}

		if (tecla == KeyEvent.VK_RIGHT) {
			this.nave.mover(movDer);
		}

		if (tecla == KeyEvent.VK_6) {
			Bala bal = this.nave.crearBala();
			nave.balas.add(bal);
			elementos.add(bal);
		}
	}

	/**
	 * 
	 */
	public void iniciar() { // metodo para los movimientos de la nave e invasores
		while (true) {
			try {
				if (!nave.balas.isEmpty()) { // se ejecuta mientras haya balas
					nave.ciclo();
				}

				if (invasores != null) {

					Nodo actual = invasores.raiz;
					while (actual != null) {
						if (!nh.hilera.equals("Hilera:E")) {
							actual.info.ciclo();
							/* mueve la hilera */}

						else {
							actual.info.cicloCircular();
							/* la hilera E recorre un ciclo circular */}

						actual = actual.sig;
					}

					seDisparaAInvasor();// metodo para disparar y matar enemigos

					if (invasores.cantidad == 0) { // Elimina TODO para comenzar nuevo nivel
						nave.setY(900);
						nave.setX(900);

						for (int i = 0; i < nave.balas.size(); i++) {
							nave.balas.get(i).setX(900);
							nave.balas.get(i).setY(900);
						}

						nh.setX(900);
						nh.setY(900);
						next.setX(900);
						next.setY(900);
						etiquetaNivel.setX(900);
						etiquetaNivel.setY(900);
						puntaje.setX(900);
						crearComponentesJuego();
					}
					/* comienza nuevo nivel.... */ }
				Thread.sleep(60);
			} // hilo para dormir
			catch (InterruptedException e) {
				System.out.println(e);
			}
			repaint();
		}
	}

	/**
	 *    
	 */
	public void seDisparaAInvasor() {
		Nodo actual = invasores.raiz;
		while (actual != null) {

			if (listaActual.equals("B")) {
				contJefe = 0;// Intercambia jefe con posicion aleatoria
				int a = (int) (Math.random() * (invasores.cantidad) + 1), cont3 = 0;// aleatoria
				Nodo aux = invasores.raiz;

				while (aux != null) {
					cont3++;// busca nodo de posicion aleatoria
					if (cont3 == a) {
						break;
					}
					aux = aux.sig;
				}

				if (Integer.parseInt(actual.info.getId().charAt(0) + "") != a - 1) {
					if (actual.sig == null && actual.ant == null) {
						actual.info.setX(900);
						actual.info.setY(900);
						invasores.borrarNodo(actual.info.getX(), actual.info.getY());
						break;
					}

					else {
						{
							invasores.intercambiar(Integer.parseInt(actual.info.id.charAt(0) + ""),
									Integer.parseInt(aux.info.id.charAt(0) + ""));
							float x = actual.info.getX();
							float y = actual.info.getY();
							actual.info.setX(aux.info.getX());
							actual.info.setY(aux.info.getY());
							aux.info.setX(x);
							aux.info.setY(y);
						}
					}
				}

				else {
					System.out.println("intercambio al mismo jefe");// Pasa si el aletorio cae en el mismo jefe

					if (actual.sig != null) {
						invasores.intercambiar(Integer.parseInt(actual.info.id.charAt(0) + ""),
								Integer.parseInt(actual.sig.info.id.charAt(0) + ""));
						float x = actual.info.getX();
						float y = actual.info.getY();
						actual.info.setX(actual.sig.info.getX());
						actual.info.setY(actual.sig.info.getY());
						actual.sig.info.setX(x);
						actual.sig.info.setY(y);
						;
					}

					if (actual.ant != null) {
						invasores.intercambiar(Integer.parseInt(actual.info.id.charAt(0) + ""),
								Integer.parseInt(actual.ant.info.id.charAt(0) + ""));
						float x = actual.info.getX();
						float y = actual.info.getY();
						actual.info.setX(actual.ant.info.getX());
						actual.info.setY(actual.ant.info.getY());
						actual.ant.info.setX(x);
						actual.ant.info.setY(y);
					}

					if (actual.ant == null && actual.sig == null) {
						actual.info.setX(900);
						actual.info.setY(900);
						invasores.borrarNodo(actual.info.getX(), actual.info.getY());
						break;
					}
					;
				}
				invasores.imprimir();
			}

			for (int i = 0; i < nave.balas.size(); i++) {

				if ((nave.balas.get(i).getY() < actual.info.getY() + 50
						&& nave.balas.get(i).getY() > actual.info.getY())
						&& (nave.balas.get(i).getX() >= actual.info.getX()
								&& (nave.balas.get(i).getX() < actual.info.getX() + 50))
						&& contDisparos == 0 && !listaActual.equals("D")) {
					nave.balas.get(i).setX(900);
					nave.balas.get(i).setY(900);
					invasores.imprimir();

					if (actual.info.getId().charAt(1) == 'j') {
						contJefe++;

						if (contJefe == 3 && listaActual.equals("B")) {
							contJefe = 0;
							invasores.borrarNodo((float) actual.info.getX(), (float) actual.info.getY());
							actual.info.setX(900);
							actual.info.setY(900);
						}

						if (contJefe == 3 && listaActual.equals("A")) {
							contJefe = 0;
							Nodo aux = invasores.raiz;
							while (aux != null) {
								invasores.vaciarLista();
								aux.info.setX(900);
								aux.info.setY(900);
								aux = aux.sig;
							}
						}

						if (contJefe == 3 && listaActual.equals("C")) {
							contJefe = 0;
							int a, cont3 = 0;
							Nodo aux = invasores.raiz;

							while (true) {
								a = (int) (Math.random() * (invasores.cantidad) + 1); // Verifica que NO caiga en el
																						// mismo jefe
								if (a != Integer.parseInt(actual.info.id.charAt(0) + "") || invasores.cantidad == 1) {
									break;
								}
							}

							while (aux != null) {
								cont3++;
								if (cont3 == a) {
									break;
								}
								aux = aux.sig;
							}

							if (actual.sig == null && actual.ant == null) {
								actual.info.setX(900);
								actual.info.setY(900);
								invasores.borrarNodo(actual.info.getX(), actual.info.getY());
								break;
							}

							if (Integer.parseInt(actual.info.getId().charAt(0) + "") != a
									&& (actual.sig != null || actual.ant != null)) {
								float x = aux.info.getX();
								float y = aux.info.getY();
								invasores.intercambiar(Integer.parseInt(actual.info.id.charAt(0) + ""),
										Integer.parseInt(aux.info.id.charAt(0) + ""));

								actual.info.setX(x);
								actual.info.setY(y);
								aux.info.setX(900);
								aux.info.setY(900);
								invasores.borrarNodo(aux.info.getX(), aux.info.getY());
								invasores.acomodarPorId();
								break;
							}
							;
						}

						if (contJefe == 3 && listaActual.equals("E")) {
							contJefe = 0;
							invasores.borrarNodo((float) actual.info.getX(), (float) actual.info.getY());
							actual.info.setX(900);
							actual.info.setY(900);
							this.acomodarHilera();
						}
					}

					else { // SI NO es jefe
						invasores.borrarNodo((float) actual.info.getX(), (float) actual.info.getY());
						actual.info.setX(900);
						actual.info.setY(900);
						break;
					}
					puntos += 5;
					acomodarHilera();
				}

				if ((nave.balas.get(i).getY() < actual.info.getY() + 50
						&& nave.balas.get(i).getY() > actual.info.getY())
						&& (nave.balas.get(i).getX() >= actual.info.getX()
								&& (nave.balas.get(i).getX() < actual.info.getX() + 50))
						&& listaActual.equals("D")) {
					this.contDisparos = 1;
					this.contDisparosHileraD[actual.info.resistencia - 1] += contDisparos;
					nave.balas.get(i).setX(900);
					nave.balas.get(i).setY(900);
					nave.balas.remove(i);

					JOptionPane.showMessageDialog(this, actual.info.resistencia);
					if (this.contDisparosHileraD[actual.info.resistencia - 1] == actual.info.resistencia) {
						actual.info.setX(900);
						actual.info.setY(900);
						invasores.borrarNodo(actual.info.getX(), actual.info.getY());
					}
					this.acomodarHilera();
					puntos += 5;
					break;
				}
			} // FIN DEL FOR

			if (actual.info.getY() == nave.getY() - 40) {// Si hilera llega a la nave gameover
				JOptionPane.showMessageDialog(this, "Fin del juego");
				this.GuardarEstadisticas(this.nombreJug, puntos);
				System.exit(0);
			}

			actual = actual.sig;
		}
		/* FIN DEL WHILE */ }

	/**
	 *     
	 */
	public void acomodarHilera() {// Acomodar hilera despues de eliminaciones.....
		int contPos = 0;
		Nodo actual = invasores.raiz;
		while (actual != null) {
			actual.info.setX((float) ((contPos + 1.5) * 100));
			contPos++;
			actual = actual.sig;
		}
	}

	/**
	 * 
	 * @param nom
	 * @param puntos
	 */
	public void GuardarEstadisticas(String nom, int puntos) {// Guarda estadisticas en txt
		try {
			File archivo = new File("estadisticas.txt");

			FileWriter escribir = new FileWriter(archivo, true);
			escribir.write(nom);
			escribir.write(" ");
			escribir.write(puntos + "");
			escribir.write("\r\n");
			escribir.close();
			/* cierra archivo txt */}

		catch (Exception e) {
			System.out.println("Error al escribir");
		}
	}
}