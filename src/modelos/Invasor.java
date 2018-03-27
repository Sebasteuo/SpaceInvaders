 
package modelos;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

 
public class Invasor  extends JLabel{
    
public Invasor(int x,int y){    
String path = "/imagenes/Invasor.png";  
URL url = this.getClass().getResource(path);  
ImageIcon icon = new ImageIcon(url);  
 setLocation(x,10);
 setSize(200,200);
 setIcon(icon);}}