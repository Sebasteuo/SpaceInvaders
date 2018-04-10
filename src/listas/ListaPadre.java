
package listas;
import nodo.*;
import javax.swing.JOptionPane;

import modelos.Invasor;
public class ListaPadre {

    public Nodo raiz;
    public int cantidad;
    
    public ListaPadre() {
        raiz=null;cantidad=0;
    }
    public void setCantidad(int c){cantidad=c;}
    public Nodo getRaiz(){return raiz;}
      
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
     
     public void crearListaCircular(){ }

    public Invasor extraer (int pos) {
        if (pos <= cantidad ())    {
            Invasor informacion;
            if (pos == 1) {
                informacion = raiz.info;
                raiz = raiz.sig;
                if (raiz!=null)
                    raiz.ant=null;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
                Nodo siguiente=prox.sig;
                if (siguiente!=null)
                    siguiente.ant=reco;
                informacion = prox.info;
            }
            return informacion;
        }
        else
            return null;
    }

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
    
    
    public void intercambiar (int pos1, int pos2) {
        if (pos1 <= cantidad () && pos2 <= cantidad ())    {
            Nodo reco1 = raiz;
            for (int f = 1 ; f < pos1 ; f++)
                reco1 = reco1.sig;
            Nodo reco2 = raiz;
            for (int f = 1 ; f < pos2 ; f++)
                reco2 = reco2.sig;
            Invasor aux = reco1.info;
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }
    
 
    
     
    public int cantidad (){
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cantidad++;  }
        return cantidad;}
    
    public boolean ordenada() {
        if (cantidad()>1) {
            Nodo reco1=raiz;
            Nodo reco2=raiz.sig;
            while (reco2!=null) {
             /*   if (reco2.info<reco1.info) {
                    return false;
                }*/
                reco2=reco2.sig;
                reco1=reco1.sig;
            }
        }
        return true;
    }
    
    public boolean existe(Invasor x) {
        Nodo reco=raiz;
        while (reco!=null) {
            if (reco.info==x)
                return true;
            reco=reco.sig;
        }
        return false;
    }
    
    public boolean vacia ()
    { return raiz == null;  }
    
    public void imprimir ()
    { Nodo actual = raiz; 
        while (actual != null) { 
            System.out.print ("Invasor #"+actual.info.getId()+" "+actual.info.getX() + "-"+actual.info.getY()); System.out.println();
          actual = actual.sig;  }
        System.out.println(); }
        
   public Nodo ultimoNodo(){
   Nodo actual=raiz;
   while(actual.sig!=null){
   actual=actual.sig;}
   return actual; }
   
   
   
   
   public void vaciarLista(){
     raiz=null;cantidad=0;
   }
   
   public void ordenarPorMayorResistencia(){}
}

           

           
