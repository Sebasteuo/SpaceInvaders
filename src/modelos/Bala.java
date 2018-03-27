 
package modelos;
 
import java.awt.Color;
import java.awt.Graphics;
 import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
public class Bala extends JLabel implements Runnable{
	
    public int getReset(){ t=null;return 0;}
    
   public void setX(int x){this.x=x;}
 
  public void setY(int y){this.y=y;}

        @Override
	public void paint(Graphics g){    
	g.setColor(Color.red);
    g.fillOval(x,y,25,25);}
 
    
        @Override
	public void run(){
		try{ while(y!=1){
         
				y--;	
				repaint();
				t.sleep(10);
                }  t=null; 
		}catch(InterruptedException e){
			running = false;}}
	
	public void start(){
		if (t == null){  
			running = true;
			t = new Thread(this);
			t.start(); } }
 
  	private int x;
	private int y;
        int cont;
        private int reset;
 	private Thread t;
	private boolean running;
}
