 
package modelos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

 
public class Invasor  extends Coordenada implements Dibujable{
    
   private float radio;
    public Color color;
    public String id;
    private int cont=0,dir=0,j=0;
    public int resistencia=0;
    private int velocidad;
    public Invasor(Coordenada cor,float r,Color c,String i,int v,int res){
    super(cor.getX(),cor.getY());
    resistencia=res;
    velocidad=v;radio=r;color=c;id=i;}
   
 
    public String getId(){return id;}
    
    public void setId(String a){id=a;}

        @Override
	public void dibujar(Graphics g){    
      
	 
     if(id.charAt(1)=='j'){ 
    ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/jefe.png")); 
g.drawImage(Img.getImage(), (int)this.getX(), (int)this.getY(), 70, 70, null);}
     
       else{
    ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/images.png")); 
g.drawImage(Img.getImage(), (int)this.getX(), (int)this.getY(), 70, 70, null);}
      }

  public void ciclo(){
      if(j%2==0){dir=0;}
      
      else{dir=1;}
      
      
     if(cont<200){ 
         float y=this.getX(); 
         if( dir==0){ 
        this.setX(y-=velocidad); }
          if( dir==1){   this.setX(y+=velocidad);}
     cont+=velocidad;}
     
     else{ 
         float x=this.getY();
         this.setY(x+=velocidad); cont=0;j++;}
     
        }
    
  
    public void cicloCircular(){
          {
          if(this.getX()<=390 && this.getY()<=40){float x=this.getX();
         this.setX(x+=velocidad); ;cont=3;}
          
         
        if(this.getX()>390&&this.getY()<200){  
            float x=this.getY();
         this.setY(x+=velocidad);    }
            
             
     if( this.getY()>=200&&(this.getX()>=220) ){     
            float x=this.getX();  
         this.setX(x-=velocidad);   }
              
            
     if(this.getX()<220&&this.getY()>40  ){ 
            float x=this.getY(); 
         this.setY(x-=velocidad);cont=0;  }    
     float s=this.getY();
               //this.setY(s+=velocidad);

}}}
        
        
          
        
