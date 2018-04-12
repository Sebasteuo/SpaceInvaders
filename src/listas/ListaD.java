 
package listas;
 
import nodo.Nodo;
import javax.swing.JOptionPane;

import modelos.Invasor;

public class ListaD extends ListaPadre {
   
    
     @Override
     public Nodo insertar ( Invasor x)//INSERTA DE FORMA CIRCULAR 
    {            if(vacia()){raiz=new Nodo(x);}
       
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
    
     @Override
          public void crearListaCircular(){
    }
     
     @Override
   public void ordenarPorMayorResistencia(){  
     if (cantidad > 1) {
        boolean cambio;
        do {
            Nodo actual = raiz;
            Nodo anterior = null;
            Nodo siguiente = raiz.sig;
            cambio = false;
            while ( siguiente != null ) {
                if (actual.info.resistencia<actual.sig.info.resistencia) {
                    cambio = true;
                    if ( anterior != null ) {
                        Nodo sig = siguiente.sig;
                        anterior.sig = siguiente;
                        siguiente.sig = actual;
                        actual.sig = sig;
                    } else {
                        Nodo sig = siguiente.sig;
                        raiz = siguiente;
                        siguiente.sig = actual;
                        actual.sig = sig;
                    }
                    anterior = siguiente;
                    siguiente = actual.sig;
                } else { 
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.sig;
                }
            } 
        } while( cambio );
    } }}