 
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
                JOptionPane.showMessageDialog(null, "sip"+cantidad);
        Nodo actual=this.raiz;Nodo aux=null;
        for(int i=1;i<cantidad;i++){
        for(int j=0;j<cantidad-1;j++){
              JOptionPane.showMessageDialog(null, actual.info.resistencia);  
            if(actual.info.resistencia>0){
    aux=actual;
            actual=actual.sig;
            actual.sig=aux;}
        actual=actual.sig   ;
        
      Nodo act=null;
      while(act!=null){
          System.out.print(act.info.id+" "+act.info.resistencia);
           System.out.println();

          act=act.sig;}
                
        
   }

        }}}