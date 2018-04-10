
package modelos;

import javax.swing.JOptionPane;

 
public class Coordenada {
   private float x;
   private float y;
    
   public Coordenada(float x, float y){ 
   this.x=x;this.y=y;}
   
   public void setX(float x){this.x=x;}
 
  public void setY(float y){this.y=y;}
  
  public float getX( ){return x;}
 
  public float getY( ){return y;}
  
  public Coordenada suma(Coordenada c){
  float sumX=this.x+c.getX();
  float sumY=this.y+c.getY();
  
  Coordenada cor=new Coordenada (sumX,sumY);
  return cor;
  
  }
}