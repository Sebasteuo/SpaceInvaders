 
package modelos;
 
import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Nave extends JLabel{
    
public Nave(){    
super("Nave");
String path = "/imagenes/Nave.png";  
URL url = this.getClass().getResource(path);  
ImageIcon icon = new ImageIcon(url);  
 setLocation(500,320);
 setSize(200,200);
 setIcon(icon);
}

}
