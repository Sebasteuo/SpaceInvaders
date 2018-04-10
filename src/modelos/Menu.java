/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
 
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel{
    public Menu(){
        this.setBackground(Color.red);}
    
    public void iniciar(){
    JLabel a=new JLabel("Nuevo Juego");
    JLabel b=new JLabel("Estadisticas");
    this.add(a);
    this.add(b);
    
    }
}
