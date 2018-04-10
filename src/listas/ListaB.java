  
package listas;

import modelos.Invasor;
import nodo.Nodo;

 public class ListaB extends ListaPadre{

  
   public void SeDestruyeAlJefe(Invasor jefe, Invasor inv){
      Nodo actual=raiz;
      
      while(actual!=null){
      actual=actual.sig;
      }
   }
}