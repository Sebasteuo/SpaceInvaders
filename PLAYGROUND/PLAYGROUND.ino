#include <Adafruit_CircuitPlayground.h>
#include <Adafruit_Circuit_Playground.h>
#include <Keyboard.h>

//boton disparo
int Disparo = A1;


//MOVIMIENTO
int Movimiento;

void setup() {
Serial.begin(9600);  // put your setup code here, to run once:
CircuitPlayground.begin(); // si usamos otra placa arduino esta parte no es necesaria
Keyboard.begin();  //inicializamos el Keyboard 

//a continuación definimos los puertos de nuestra placa, todos como entradas como se muestra
pinMode (Disparo, INPUT); 


}

void loop() {
Movimiento = CircuitPlayground.motionX();


//Indicamos que teclas queremos que se activen cada vez que presionamos un boton

//flecha izquierda
if (digitalRead(Disparo) == HIGH){
  Keyboard.press(32); //codigo ASCII de espacio
  }
delay(70);

//MOVIMIENTO IZQUIERDO
if (Movimiento == 2 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}

if (Movimiento == 3 ){ // DERECHA
  Keyboard.press(KEY_LEFT_ARROW);
}
if (Movimiento == 4 ){ // DERECHA
  Keyboard.press(KEY_LEFT_ARROW);
}
if (Movimiento == 5 ){ // DERECHA
  Keyboard.press(KEY_LEFT_ARROW);
}
if (Movimiento == 6 ){ // DERECHA
  Keyboard.press(KEY_LEFT_ARROW);
}
if (Movimiento == 7 ){ // DERECHA
  Keyboard.press(KEY_LEFT_ARROW);
}
if (Movimiento == 8 ){ // DERECHA
  Keyboard.press(KEY_LEFT_ARROW);
}
if (Movimiento ==  9){ // DERECHA
  Keyboard.press(KEY_LEFT_ARROW);
}
if (Movimiento == 10 ){ // DERECHA
  Keyboard.press(KEY_LEFT_ARROW);
}
if (Movimiento == 11 ){ // DERECHA
  Keyboard.press(KEY_LEFT_ARROW);
}



//VALORES PARA DERECHA
if (Movimiento == -1 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}

if (Movimiento == -1.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -2 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -2.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -3 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -3.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -4 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -4.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -5){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -5.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -6 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}

if (Movimiento == -6.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -7 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -7.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -8 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -8.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -9 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -9.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -10){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}
if (Movimiento == -10.5 ){ // DERECHA
  Keyboard.press(KEY_RIGHT_ARROW);
}




delay (10);

//esta parte de la programación es para indicarte la PC

// que tiene que liberar las teclas, porque si no las teclas quedarían presionadas

Keyboard.releaseAll();
}
