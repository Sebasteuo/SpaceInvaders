package modelos;

import listas.*;
import nodo.Nodo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
public class Ventana extends javax.swing.JFrame implements KeyListener  {

     private Nave nave;
     private Bala bala;
     private ListaPadre invasores;
     
    public Ventana() {
       		 super("Space Invaders");	
             int tam=5;
              
             String v[]={"A","B","D","E","C","Basic"};
            String lista=v[(int) (Math.random() * v.length-1) ];
             
             if(lista.equals("Basic")){invasores =new ListaBasic();invasores.setCantidad(tam);}
             if(lista.equals("A")){invasores =new ListaA();invasores.setCantidad(tam);}
             if(lista.equals("B")){invasores =new ListaB();invasores.setCantidad(tam);}
             if(lista.equals("C")){invasores =new ListaC();invasores.setCantidad(tam);}
             if(lista.equals("D")){invasores =new ListaD();invasores.setCantidad(tam);}
             if(lista.equals("E")){invasores =new ListaE();invasores.setCantidad(tam);}
             
             for(int i=0;i<tam;i++){
                 Invasor inv=new Invasor(i*100,2);
             invasores.insertar (inv); }
               setDefaultCloseOperation(EXIT_ON_CLOSE); 
             JLabel hilera=new JLabel("Hilera:"+lista);
              hilera.setLocation(tam*95,100);
 hilera.setSize(90,90);
hilera.setForeground(Color.white);
 add(hilera);
             Nodo actual=invasores.raiz;
            while(actual!=null){System.out.println(3);
            add(actual.info);
                actual=actual.sig;}
             
                  this.getContentPane().setBackground(Color.DARK_GRAY);
                   
                       this.addKeyListener(this);
                     nave=new Nave();add(nave);
                   bala=new Bala();
                   add(bala);
                 this.addKeyListener(this);}   

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
       int x= nave.getX();
       int y=nave.getY();
       if(e.getKeyCode()==37){x-=3;} //izquierda
       //if(evt.getKeyCode()==38){y+=2;}
       if(e.getKeyCode()==39){x+=3;}//derecha
       //if(evt.getKeyCode()==40){y-=2;}
 
        if(e.getKeyCode()==32){   
            
             bala.setX(x);
            bala.setY(y);
         bala.start();
        }//tecla space para disparar las balas 
        nave.setLocation(x,y);    }

    @Override
    public void keyReleased(KeyEvent e) { }
 
}