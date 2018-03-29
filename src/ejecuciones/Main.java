 
package ejecuciones;
import listas.ListaA;
import listas.ListaB;
import listas.ListaBasic;
import listas.ListaC;
import listas.ListaD;
import listas.ListaE;
import listas.ListaPadre;
import modelos.Asteroide;
import modelos.Bala;
import modelos.Coordenada;
import modelos.Invasor;
import modelos.Nave;
import modelos.NombreHilera;
import modelos.PanelJuego;
 import modelos.Ventana;
import nodo.Nodo;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Main {
    
    
  public static void main(String []args){
     Ventana v=new Ventana("Space Invaders"); 
 ArrayList elem=new ArrayList();
 Coordenada c= new Coordenada(525,400);
 Coordenada c1= new Coordenada(475,450);
  Coordenada c2= new Coordenada(575,450);
   Nave n=new Nave(c,c1,c2,Color.red);
  elem.add(n);

      
       Bala bala;
       ListaPadre invasores=null;
       int tam=5;
        String hile[]={"A","B","D","E","C","Basic"};
            String lista=hile[(int) (Math.random() * hile.length-1) ];
             
             if(lista.equals("Basic")){invasores =new ListaBasic();invasores.setCantidad(tam);}
             if(lista.equals("A")){invasores =new ListaA();invasores.setCantidad(tam);}
             if(lista.equals("B")){invasores =new ListaB();invasores.setCantidad(tam);}
             if(lista.equals("C")){invasores =new ListaC();invasores.setCantidad(tam);}
             if(lista.equals("D")){invasores =new ListaD();invasores.setCantidad(tam);}
             if(lista.equals("E")){invasores =new ListaE();invasores.setCantidad(tam);}
    
 
 //Invasor []d=new Invasor[tam];
             for(int i=0;i<tam;i++){
                 Invasor inv=new Invasor( new Coordenada((i+1)*100,0),40,Color.BLUE);
             invasores.insertar (inv);   elem.add(inv); }
             
 Bala []b=new Bala[tam];
    for(int i=1;i<=tam;i++){ 
                 Bala balaInvasor=new Bala(new Coordenada((i)*110,40),10,Color.MAGENTA); b[i-1]=balaInvasor;
                 elem.add(b[i-1]); }
 
     NombreHilera nh=new NombreHilera(565,50,40,"Hilera: "+lista);
 elem.add(nh);
   PanelJuego panel =new PanelJuego( elem);
  panel.Crearnave(n);   
  panel.crearBalasInvasor(b);
  v.add(panel);
  
 v.setSize(700, 500);
 v.setVisible(true);
 v.setBackground(Color.BLACK);
 
 panel.iniciar(); }}