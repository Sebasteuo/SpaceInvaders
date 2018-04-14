
package listas;
import nodo.*;
 
import modelos.Invasor;
/**
 * 
 * @author sebastianalba
 *
 */
public class ListaPadre {

    public Nodo raiz;
    public int cantidad;
    
    public ListaPadre() {
        raiz=null;cantidad=0;
    }
    /**
     * modifica el valor de la cantidad de elementos de la lista según el parámetro c.
     * @param c
     */
    public void setCantidad(int c){cantidad=c;}
    /**
     * Obtiene la raiz Osea el primer elemento de la lista.
     * @return
     */
    public Nodo getRaiz(){return raiz;}
/**
 *   Esta función se encarga se insertar el nuevo Nodo Osea invasor en la lista, primero se pregunta si la lista esta vacia , si lo es se inserta el invasor de primero o de raiz , sino se inserta luego del primer Nodo , después se agregan los punteros de anterior y siguiente para enlazar el nuevo nodo a la lista.    
 * @param x
 * @return
 */
     public Nodo insertar (Invasor x)
    {   
       if(vacia()){raiz=new Nodo(x);}
       
       else{  
       Nodo actual=raiz;
       while(actual.sig!=null){
      actual=actual.sig; }
       Nodo s=new Nodo(x);
       actual.sig=s;
       s.ant=actual;cantidad++;
       return actual;
        } 
    cantidad++;return raiz;}
/**
 * Este método basicamente lo que hace es enlazar el último nodo de la lista con el primero, esto quiere decir que el nodo siguiente del nodo ultimo será el primer nodo de la lista , mientras que el anterior nodo del primer nodo será el último.    
 */
     public void crearListaCircular(){ }

 /**
  * Esta función recibe como parámetro una coordenada (x,y) de algún invasor de la hilera, lo que hace es eliminarlo de la hilera o la lista , primero se recorre el ciclo while para buscar el invasor en la lista , cuando lo encuentre se verifican varias cosas:
si el invasor es el primero de la lista , se elimina y el primero ahora va a ser el siguiente del primero.
si el invasor está en el medio de la lista , se elimina y en su posición queda el que estaba siguiente a el.
si el invasor es el último de la lista , se elimina y el último de la lista va a ser el anterior a este.    
  * @param x
  * @param y
  * @return
  */
    public  boolean borrarNodo(float x,float y)
	{cantidad--;
		Nodo anterior=null;
		Nodo actual=raiz;
		while(actual!=this.ultimoNodo()) { 
			if(actual.info.getX()==x&&actual.info.getY()==y)
			{		 

				if(anterior==null)
				{ raiz=actual.sig;
					raiz.ant=null;
				}
				else{
					anterior.sig=actual.sig;
					Nodo temporal;
					temporal=actual.sig;
					temporal.ant=anterior;
				}
				return true;
			}
			anterior=actual;
			actual=actual.sig;
		}
		if(this.ultimoNodo().info.getX()==x&&this.ultimoNodo().info.getY()==y) { 
                     Nodo u=this.ultimoNodo();
                     if(cantidad!=0) {
                     u.ant.sig=null; }
			 
			return true; 	}
		return false; }
 /**
  *  Este método se encarga de intercambiar dos nodos, en este caso el jefe con cualquier aleatorio invasor, primero se crea un Nodo auxiliar y luego se recorre el ciclo while hasta encontrar la posición del jefe, igual que con el invasor se recorre el otro while,  des pués se procede a intercambiar ambos nodos.  
  * @param pos1
  * @param pos2
  */
    
    public void intercambiar (int pos1, int pos2) {
         System.out.println(pos1+"----"+pos2);

            Nodo reco1 = raiz;
            while(Integer.parseInt(reco1.info.id.charAt(0)+"")!=pos1){
                reco1 = reco1.sig;}
            
            Nodo reco2 = raiz;
                while(Integer.parseInt(reco2.info.id.charAt(0)+"")!=pos1){
                reco2 = reco2.sig;}
            
             System.out.println(reco1+"--"+reco2);
            Invasor aux = reco1.info;
            reco1.info = reco2.info;
            reco2.info = aux;
           
            
        }
    
 /**
  *    
  */
    public void ordenarPorResistencia(){
   
    
    
    }
/**
 *  
 */
    public void acomodarPorId(){
    Nodo actual=raiz;int cont=1;
    while(actual!=null){
        actual.info.id=cont+""+actual.info.id.charAt(1);
        cont++;
        actual=actual.sig;}
        
    }
/**
 *      
 * @return
 */
    public int cantidad (){
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cantidad++;  }
        return cantidad;}
/**
 *     
 * @param x
 * @return
 */
   
    
    public boolean existe(Invasor x) {
        Nodo reco=raiz;
        while (reco!=null) {
            if (reco.info==x)
                return true;
            reco=reco.sig;
        }
        return false;
    }
/**
 *     
 * @return
 */
    public boolean vacia ()
    { return raiz == null;  }
/**
 *    Basicamente este método se encarga de mostrar todos los elementos de la lista , con su coordenada , su id y su resistencia. 
 */
    public void imprimir ()
    { Nodo actual = raiz; 
        while (actual != null) { 
            System.out.print ("Invasor #"+actual.info.getId()+" "+actual.info.getX() + "-"+actual.info.getY()+"-"+actual.info.resistencia); System.out.println();
          actual = actual.sig;  }
        System.out.println(); }
/**
 *         
 * @return
 */
   public Nodo ultimoNodo(){
   Nodo actual=raiz;
   while(actual.sig!=null){
   actual=actual.sig;}
   return actual; }
   
   
/**
 *    Este método se encarga de vaciar la lista , poniendo el nodo primero (raiz) como nulo y la cantidad como cero.
 */
   
   public void vaciarLista(){
     raiz=null;cantidad=0;
   }
/**
 *Esta función se encarga de ordenar la lista , en este caso la lista D según las resistencias de Mayor a menor , se ordena usando el algoritmo Bubble sort , primero se recorre el ciclo while para buscar el siguiente nodo del primer nodo (raiz) , cuando se encuentre se compara con el primero para ver si es mayor o menor, si el primero es menor al siguiente se procede con el intercambio , sino , no se intercambia.    
 */
   public void ordenarPorMayorResistencia(){}
/**
 *    
 * @param pos1
 * @param pos2
 */
   public void seDestruyeAlJefe(int pos1, int pos2){}
}

           
 
