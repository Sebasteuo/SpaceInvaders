package modelos;
import personaje.*;
import listas.*;
import nodo.Nodo;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 import java.io.File;
import java.io.FileWriter;
 import java.io.FileReader;
import java.io.BufferedReader;

public class PanelJuego extends JPanel implements KeyListener{
     ArrayList elementos;//ArrayList de elementos del Panel (Invasores, nave, balas......)
     private Nave nave;
     private final Coordenada movIzq=new Coordenada(-25,0);
     private final Coordenada movDer=new Coordenada(25,0);
     private ListaPadre invasores;//Hilera de invasores
     private ArrayList <NombreHilera>nombreHileras=new ArrayList<NombreHilera>();
    private int cont=0,contJefe=0,tam=5,puntos=0,velocidad=3,centrado=0;
    private String nombreJug,lista  ,hile[]={"A","B","D","E","C","Basic"},list="",opcion;
    private NombreHilera nh,next,nombre,puntaje,nivel;
    public PanelJuego(){ 
    this.addKeyListener(this);
    this.setFocusable(true);
    opcion=JOptionPane.showInputDialog("Space Invaders \n  a. Jugar. \n b. ver Estadisticas? \n c. Acerca de. \n d. Salir.");
      if(opcion.equals("a")){ 
         nombreJug= JOptionPane.showInputDialog("Digite su nombre:");
     
    this.crearComponentes( );}
      if(opcion.equals("b")){this.CargarEstadisticas();System.exit(0);}
    if(opcion.equals("c")){}
    if(opcion.equals("d")){System.exit(0);} 
     
  }                       
     
    public void crearComponentes( ){ 
    elementos=new ArrayList();
      lista=hile[(int)(Math.random()*(tam-1) + 0 )];
    this.crearNuevaHilera(); }
    
    public void crearNuevaHilera() {cont++;
       Coordenada c= new Coordenada(525,400);
 Coordenada c1= new Coordenada(475,450);
  Coordenada c2= new Coordenada(575,450);
   Nave n=new Nave(c,c1,c2,Color.red);
  elementos.add(n);
nave=n;
  nh=new NombreHilera(0,20,40,"Hilera:"+lista,Color.RED);
 elementos.add(nh);  
          list=lista;

      ////////////////////////////////////////////CREA LISTA
               lista=hile[(int)(Math.random()*(tam-1) + 0 )];
                      ListaPadre invasores=null;
             if(lista.equals("Basic")){invasores =new ListaBasic(); ;}
             if(lista.equals("A")){invasores =new ListaA(); }
             if(lista.equals("B")){invasores =new ListaB(); }
             if(lista.equals("C")){invasores =new ListaC(); }
             if(lista.equals("D")){invasores =new ListaD(); }
             if(lista.equals("E")){invasores =new ListaD(); }
             
              char jefe[]={'j','i'};int d=0;
              
            for(int i=0;i<tam;i++){
                String j=i+"x";
                char jef=  jefe[(int)(Math.random()*(2) + 0 )];
 if(jef=='j'&&d==0&&!lista.equals("Basic")){d=1;j=i+"j"+""; }
 else{    
 if(((jef=='i' )||(jef=='j'&&d==1))&&(!lista.equals("Basic"))){
     j=i+"i"+""; } }
    if(nh.hilera.equals("Hilera:E")){
                  Invasor inv=new Invasor(new Coordenada((i)*100,40),40,Color.BLUE,j,velocidad);
     invasores.insertar(inv);
             elementos.add(inv);}
    else{    Invasor inv=new Invasor(new Coordenada((i+2)*100,40),40,Color.BLUE,j,velocidad);
     invasores.insertar(inv);
             elementos.add(inv);}
             
              invasores.crearListaCircular();  }    velocidad+=2;
  /////////////////////////////////////////////////////CREA NOMBRE DE HILERA         
   next=new NombreHilera(100,20,40,"ProxHile: "+lista,Color.RED);
 elementos.add(next);
   nivel=new NombreHilera(450,20,40,"Nivel: "+cont,Color.RED);
 elementos.add(nivel);
     nombre=new NombreHilera(250,20,40,"Nombre: "+nombreJug,Color.RED);
 elementos.add(nombre); 
    puntaje=new NombreHilera(550,20,40,"Puntaje: "+puntos,Color.RED);
 elementos.add(puntaje); this.invasores=invasores;}
    
    @Override
    public void paint(Graphics g){//Dibuja cada elemento del Panel 
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
    public void keyTyped(KeyEvent e) {}

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
       elementos.add(bal); }}
    
    public void iniciar(){ 
    while(true){
        try{
            if(!nave.balas.isEmpty()){nave.ciclo();}
            Nodo actual=invasores.raiz;
              while(actual!=null){
                  if(!nh.hilera.equals("Hilera:E")){actual.info.ciclo();}
                  
                  else{ 
                      actual.info.cicloCircular();}
                  
               if(actual.info.getY()==nave.getY()){actual.info.setY(0);
                   JOptionPane.showMessageDialog(this, "Fin del juego");this.GuardarEstadisticas(this.nombreJug, puntos);System.exit(0); }
                   actual=actual.sig;  }
              seDisparaAInvasor();
               if(invasores.cantidad==0){ //this.removeAll();this.repaint();
                   nave.setY(900);  nave.setX(900);  
                   for(int i=0;i<nave.balas.size();i++){
                   nave.balas.get(i).setX(900);
                   nave.balas.get(i).setY(900);}
                    nh.setX(900); nh.setY(900);
                     next.setX(900); next.setY(900);
                        nivel.setX(900); nivel.setY(900);this.puntaje.setX(900);
                   this.crearNuevaHilera();  }
         Thread.sleep(60);  }
        catch(InterruptedException e){System.out.println(e);}
    repaint();} }
     
     public void seDisparaAInvasor(){ 
      Nodo actual=invasores.raiz;
      while(actual!=null){
          for (int i=0;i<nave.balas.size();i++) {
          if( (nave.balas.get(i).getY()<actual.info.getY()+50&&nave.balas.get(i).getY()>actual.info.getY())&&(nave.balas.get(i).getX()<actual.info.getX()+80&&nave.balas.get(i).getX()>actual.info.getX())){ 
    if( actual.info.getId().charAt(1)=='j'){contJefe++; 
             if( contJefe==3&&list.equals("A")){contJefe= 0;
                Nodo aux=invasores.raiz;
               while(aux!=null){ 
                   invasores.vaciarLista();
                   aux.info.setX(900);
                   aux.info.setY(900);
                   aux=aux.sig;}}
            
              if(contJefe==3&&list.equals("B")){ contJefe=0;
                 int a=  (int)(Math.random()*(tam) +  1),cont=1;
                 Nodo aux=invasores.raiz;
                 while(aux!=null ){
                     if(a==cont){
                         float x=aux.info.getX(); float y=aux.info.getY();

                   aux.info.setX(900);
                  aux.info.setY(900);
                  invasores.borrarNodo(aux.info.getX(), aux.info.getY());

                  invasores.imprimir();
                    actual.info.setX(x);
                    actual.info.setY(y);break;}
                     
                     cont++;
                        aux=aux.sig;  }  }
             
           if( contJefe==3&&list.equals("C")){ contJefe=0;
               invasores.borrarNodo((float)actual.info.getX(),(float)actual.info.getY()); 
                actual.info.setX(900);
                   actual.info.setY(900);}
            if(contJefe==3&&list.equals("D")){contJefe=0;
                invasores.borrarNodo((float)actual.info.getX(),(float)actual.info.getY()); 
                actual.info.setX(900);
           actual.info.setY(900);} 
            
            
             if(contJefe==3&&list.equals("E")){contJefe=0;
              invasores.borrarNodo((float)actual.info.getX(),(float)actual.info.getY()); 
                actual.info.setX(900);
           actual.info.setY(900);}
          }
             else{
                    invasores.borrarNodo((float)actual.info.getX(),(float)actual.info.getY()); 
                actual.info.setX(900);
           actual.info.setY(900);  }
          
           puntos+=5;acomodarHilera();} 
          } actual=actual.sig;  } 
     }
     
  public void acomodarHilera()   { 
  Nodo actual=invasores.raiz;
  while(actual!=null){
      actual.info.setX((centrado+2)*100);
      centrado++; 
  actual=actual.sig;}centrado=0;
  }
    
public void GuardarEstadisticas(String nom,int puntos)
{
try
{File archivo=new File("estadisticas.txt");

FileWriter escribir=new FileWriter(archivo,true);
escribir.write(nom);
escribir.write(" ");
escribir.write(puntos+"");
escribir.write("\r\n");
 escribir.close();
}

catch(Exception e)
{
System.out.println("Error al escribir");
}
}


public void CargarEstadisticas ( )
{
//Creamos un String que va a contener todo el texto del archivo
String texto="";

try
{
FileReader lector=new FileReader("estadisticas.txt");

BufferedReader contenido=new BufferedReader(lector);
System.out.println("Estadisticas de juego:");
while((texto=contenido.readLine())!=null)
{
System.out.println(texto);
}
}

catch(Exception e){
System.out.println("Error al leer");

}}}