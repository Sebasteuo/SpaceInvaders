package modelos;

import listas.*;
import nodo.Nodo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
public class Ventana extends javax.swing.JFrame implements WindowListener   {

    public Ventana(String titulo) {
       		 super(titulo);	
     
             
                /*      nave=new Nave();add(nave);
                   bala=new Bala();
                   add(bala);*/ 
                 this.addWindowListener(this);}   

    @Override
    public void windowOpened(WindowEvent e) {
     }

    @Override
    public void windowClosing(WindowEvent e) {System.exit(0);
     }

    @Override
    public void windowClosed(WindowEvent e) { 
     }

    @Override
    public void windowIconified(WindowEvent e) {
     }

    @Override
    public void windowDeiconified(WindowEvent e) {
     }

    @Override
    public void windowActivated(WindowEvent e) {
     }

    @Override
    public void windowDeactivated(WindowEvent e) {
     }

}