package modelos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

 
public class Invasor  extends Coordenada implements Dibujable{
    
   private float radio;
    private Color color;
    
    public Invasor(Coordenada cor,float r,Color c){super(cor.getX(),cor.getY());radio=r;color=c;}
   

        @Override
	public void dibujar(Graphics g){    
      
	 
     
    ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/Invasor.jpg")); 
g.drawImage(Img.getImage(), (int)this.getX(), (int)this.getY(), 70, 70, null);

    
    //String d="\jjkjjj/";g.setColor( Color.YELLOW );
 
  

// g.drawLine(40,20,60, 25);

 
    }



}