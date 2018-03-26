package modelos;
 
import java.awt.Color;
import java.awt.event.*;

public class Ventana extends javax.swing.JFrame implements WindowListener {
 
    public Ventana(String title) {
          super(title);
          setSize(500,500);
        this.addWindowListener(this);
      setBackground(Color.LIGHT_GRAY);}

    @Override
    public void windowOpened(WindowEvent e) {
     }

    @Override
    public void windowClosing(WindowEvent e) {
     }

    @Override
    public void windowClosed(WindowEvent e) {
     }

    @Override
    public void windowIconified(WindowEvent e) {
     }

    @Override
    public void windowDeiconified(WindowEvent e) {
     }

    @Override
    public void windowActivated(WindowEvent e) {
     }

    @Override
    public void windowDeactivated(WindowEvent e) {
     }

}