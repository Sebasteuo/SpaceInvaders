  
package listas;

import modelos.Invasor;
import nodo.Nodo;

 public class ListaC extends ListaPadre{ //LISTA CIRCULAR
   
      public void insertar (int pos, Invasor x)//INSERTA DE FORMA CIRCULAR 
    {
        if (pos <= cantidad () + 1)    {
            Nodo nuevo = new Nodo (x);
            nuevo.info = x;
            if (pos == 1){
                nuevo.sig =  getRaiz();
                if ( getRaiz()!=null)
                     getRaiz().ant=nuevo;
                 raiz = nuevo;
            } else
                if (pos == cantidad () + 1)    {
                    Nodo reco =  getRaiz();
                    while (reco.sig != null) {
                        reco = reco.sig;
                    }
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = null;
                } else {
                    Nodo reco =  getRaiz();
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        reco = reco.sig;
                    Nodo siguiente = reco.sig;
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = siguiente;
                    siguiente.ant=nuevo;
                }
        }
    }
        public void SeDestruyeAlJefe(){}

}
