  
package listas;

import modelos.Invasor;
import nodo.Nodo;

 public class ListaB extends ListaPadre{

     @Override
   public void intercambiar (int pos1, int pos2) {
      {
            Nodo jefe = raiz;
            while(jefe!=null&&Integer.parseInt(jefe.info.id.charAt(0)+"")!=pos1){
                jefe = jefe.sig;}
            
            Nodo actual = raiz;
             while(actual!=null&&Integer.parseInt(actual.info.id.charAt(0)+"")!=pos2){
                actual = actual.sig;}
             
            Invasor aux = jefe.info;
            jefe.info = actual.info;
            actual.info = aux;
        }
    }
}