package modelos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
 
public class NombreHilera extends Coordenada  implements Dibujable{

     String hilera;
int radio;
    public NombreHilera(float x, float y,int r,String lista) {
        super(x,y);
radio=r;
      hilera=lista;
    }
  
 
    @Override
    public void dibujar(Graphics g) { 
 
           
       int fontSize = 20;
    g.setFont(new Font("Arial", Font.PLAIN, fontSize));
    g.setColor(Color.WHITE);
    g.drawString(hilera,(int) this.getX(), (int)this.getY());
     } 
    
}
