 
package personaje;
 
import modelos.Coordenada;
import modelos.Dibujable;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class Asteroide extends Coordenada implements Dibujable{

    int largo;
    int ancho;
    Color color;
    public Asteroide(Coordenada c, int a, int b, Color col){ 
    super(c.getX(),c.getY()); 
    largo=a;ancho=b;color=col;
    }
    
 
    @Override
    public void dibujar(Graphics g) { 
        g.setColor(color);
        g.fillRect((int)getX(), (int)getY(), largo, ancho); 
     }
    
    
    
}
