 
package modelos;
 
import java.awt.Color;
import java.awt.Graphics;
 import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
public class Bala extends JLabel implements Runnable{
	
  
        @Override
	public void paint(Graphics g){  JOptionPane.showMessageDialog(null,9+"----");
	g.setColor(Color.red);
    g.fillOval(x,y,25,25);
        }
 
    
        @Override
	public void run(){
		try{ while(y!=1){
                    System.out.println(x+"----"+y);
				y--;	
				repaint();
				t.sleep(10);}  t=null; 
		}catch(InterruptedException e){
			running = false;}}
	
	public void start(){
		if (t == null){ JOptionPane.showMessageDialog(null,x+"----"+y);
			running = true;
			t = new Thread(this);
			t.start(); } }
 
  	private int x;
	private int y;
 	private Thread t;
	private boolean running;
}
