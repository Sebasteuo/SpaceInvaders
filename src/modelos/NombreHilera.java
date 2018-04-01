package modelos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
 
public class NombreHilera extends Coordenada  implements Dibujable{

     String hilera;
     Color color;
    public NombreHilera(float x, float y,int r,String lista,Color col) {
        super(x,y);
  color=col;
  hilera=lista; }
  
 
    @Override
    public void dibujar(Graphics g) { 
 
           
       int fontSize = 20;
    g.setFont(new Font("Arial", Font.PLAIN, fontSize));
    g.setColor(color);
    g.drawString(hilera,(int) this.getX(), (int)this.getY());  } 
    
}