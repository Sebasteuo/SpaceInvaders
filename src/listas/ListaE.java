  
package listas;

import nodo.Nodo;


import modelos.Invasor;
/**
 * 
 * @author sebastianalba
 *
 */
 public class ListaE extends ListaPadre{
 
	 /**
	  * INSERTA DE FORMA CIRCULAR y DOBLE
	  * Esta función se encarga se insertar el nuevo Nodo Osea invasor en la lista, primero se pregunta si la lista esta vacia , si lo es se inserta el invasor de primero o de raiz , sino se inserta luego del primer Nodo , después se agregan los punteros de anterior y siguiente para enlazar el nuevo nodo a la lista.
	  */
     @Override
      public Nodo insertar (  Invasor x)//INSERTA DE FORMA CIRCULAR y DOBLE
    {      if(vacia()){raiz=new Nodo(x);}
       
       else{  
       Nodo actual=raiz;
       while(actual.sig!=null){
      actual=actual.sig; }
       Nodo s=new Nodo(x);
       actual.sig=s;
       s.ant=actual;cantidad++;
       return actual;  } 
    cantidad++;return raiz;
    }
     
   /**
    *Este método basicamente lo que hace es enlazar el último nodo de la lista con el primero, esto quiere decir que el nodo siguiente del nodo ultimo será el primer nodo de la lista , mientras que el anterior nodo del primer nodo será el último.  
    */
      @Override
          public void crearListaCircular(){
     Nodo ultimo=this.ultimoNodo();
     ultimo.sig=raiz.ant; }
   
          
}