 
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
    public Color color;
    private String id;
    public Invasor(Coordenada cor,float r,Color c,String i){super(cor.getX(),cor.getY());radio=r;color=c;id=i;}
   
 
    public String getId(){return id;}
    
    public void setId(String a){id=a;}

        @Override
	public void dibujar(Graphics g){    
      
	 
     if(id.charAt(1)=='j'){
    ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/jefe.jpg")); 
g.drawImage(Img.getImage(), (int)this.getX(), (int)this.getY(), 70, 70, null);}
     
       else{
    ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/Invasor.jpg")); 
g.drawImage(Img.getImage(), (int)this.getX(), (int)this.getY(), 70, 70, null);}
      }

  public void ciclo(){
         float x=this.getY();
        this.setY(x+=20);   
        }


}