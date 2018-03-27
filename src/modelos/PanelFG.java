package modelos;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.util.*;
public class PanelFG extends JPanel implements KeyListener {
    
ArrayList elementosJuego;    
    
public PanelFG(ArrayList a){elementosJuego=a;}    
    
public void paint(Graphics g){
Dibujable dib;

for(int i=0;i<elementosJuego.size() ;i++){
dib= (Dibujable)elementosJuego.get(i);
dib.dibujar(g);}}

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        JOptionPane.showMessageDialog(this, "hola!!!!");
     }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }}