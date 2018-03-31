  
package listas;

import nodo.Nodo;
import javax.swing.JOptionPane;

import modelos.Invasor;

 public class ListaE extends ListaPadre{
     
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
     
   public void rotacion(){}
   
      @Override
          public void crearListaCircular(){
     Nodo ultimo=this.ultimoNodo();
     ultimo.sig=raiz.ant; }
   
}