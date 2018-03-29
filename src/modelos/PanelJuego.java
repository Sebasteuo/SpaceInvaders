 
package modelos;

import listas.ListaA;
import listas.ListaB;
import listas.ListaBasic;
import listas.ListaC;
import listas.ListaD;
import listas.ListaE;
import listas.ListaPadre;
import nodo.Nodo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class PanelJuego extends JPanel implements KeyListener{
    ArrayList elementos;
    private Nave nave;
    public Bala balasInv[] ;
         private Coordenada movIzq=new Coordenada(-25,0);
      private Coordenada movDer=new Coordenada(25,0);
       private Coordenada movCentro=new Coordenada(0,0);
     
     private Bala bala;
     private ListaPadre invasores;
    public PanelJuego(ArrayList v){elementos=v;
    balasInv=new Bala[5];
    this.addKeyListener(this);
    this.setFocusable(true);
    
    }
    
    
    @Override
    public void paint(Graphics g){
        Dimension d=getSize();
        Image im=createImage(d.width,d.height);
        Graphics buff=im.getGraphics();
        
    Dibujable dib;
    for(int i=0;i<elementos.size() ;i++){
    dib=(Dibujable) elementos.get(i);
    dib.dibujar(buff);
    }g.drawImage(im, 0, 0, null);}

    
    @Override
   public void update(Graphics g){paint(g);}
   
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
int tecla=e.getKeyCode();

     if(tecla==KeyEvent.VK_LEFT){
     this.nave.mover(movIzq); }
     
     
    if(tecla==KeyEvent.VK_RIGHT){        
     this.nave.mover(movDer); }  
     
        if(tecla==KeyEvent.VK_SPACE){   
            Bala bal= this.nave.crearBala();
nave.balas.add(bal);
       elementos.add(bal); } }

    @Override
    public void keyReleased(KeyEvent e) {int tecla=e.getKeyCode();

     if(tecla==KeyEvent.VK_LEFT){
     this.nave.mover(movIzq);}
     
     
    if(tecla==KeyEvent.VK_RIGHT){        
     this.nave.mover(movDer); } 
    
       if(tecla==KeyEvent.VK_6){        
Bala bal= this.nave.crearBala();
nave.balas.add(bal);
       elementos.add(bal); }
    }
    
    public void Crearnave(Nave na){nave= na;}

    public void iniciar(){
    while(true){
        try{
            if(!nave.balas.isEmpty()){nave.ciclo();}
             {   for(int i=0;i<balasInv.length;i++){
               balasInv[i].ciclo();}
             for(int i=0;i<balasInv.length;i++){
             if(balasInv[i].getY()==600){balasInv[i].setY(0);}}}
             colision();esAtacado();
        Thread.sleep(60);
        }
        catch(InterruptedException e){System.out.println(e);}
        
    repaint();}
    }

public void crearBalasInvasor(Bala []v){
    for(int i=0;i<balasInv.length;i++){
        balasInv[i]=v[i];}}

    public void colision() {
 for(int i=0;i<nave.balas.size();i++){
Bala b=  (Bala)nave.balas.get(i);
  
     for(int j=0;j<5;j++){
            if(b.getX()==((j+1)*100)&&b.getY()==55){
                JOptionPane.showMessageDialog(this, "Le disparastes a un invasor!!");}}
    }}

    
    public void esAtacado() {
 for(int i=0;i<this.balasInv.length;i++){
Bala b=  (Bala)this.balasInv[i];
   {
            if(b.getX()==nave.getX()&&b.getY()==nave.getY()){
                JOptionPane.showMessageDialog(this, "Te han disparado!!!! perdistes");System.exit(0);}}
    }}
}