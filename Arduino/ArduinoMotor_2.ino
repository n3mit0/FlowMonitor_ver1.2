// C++ code
//author: Julieth Rojas

#include "math.h"
#include "Sensor.h"

Sensor temperatura;
int temp = 0;

//encoder
int pulsos = 0;
unsigned long previousMillis = 0;
long interval = 1000;  // un segundo
double rev;            // pulsos del eje de la carga en 1 revolución
int rpm = 0;

//driver
int in3 = 7;
int in4 = 6;
int EnB = 10;  // driver pwm de salida
int pv = 0;    // variable de proceso - lo que contiende pwm salida

//función de velocidad
double vel = 0.0;
double velFuntion = 0.0;

void setup() {

  // pines driver
  pinMode(in3, OUTPUT);
  pinMode(in4, OUTPUT);
  pinMode(EnB, OUTPUT);

  Serial.begin(115200);

  // Flancos de subida pin3 del encoder motor
  attachInterrupt(1, contador, RISING);

}

void loop() {
  while (Serial.available() > 0) {
    String val = Serial.readString();
    //Serial.print(val);

    if ((val == "1") || (val == "2") || (val == "3")) {
      if (val == "1") {
        int actual = temperatura.getTemperature();
        Serial.println(actual);
      } else {
        if (val == "2") {
          // valor velocidad
          vel = encoder();
          if (vel > 0) {
            vel = vel;
          } else {
            vel = 0;
          }
          Serial.println(vel);
        } else {
          int actual = temperatura.getTemperature();
          vel = encoder();
          if (vel > 0) {
            vel = vel;
          } else {
            vel = 0;
          }
          Serial.print(actual);
          Serial.print(":");
          Serial.print(vel);
        }
      }
    }
  }

  motor();
}

int encoder() {
  unsigned long currentMillis = millis();

  if ((currentMillis - previousMillis) >= interval) {
    previousMillis = currentMillis;
    rpm = (pulsos * (60.0 / (20)));  //RPM del eje principal
    //reinicio

    pulsos = 0;
  }
  return rpm;
}


void contador() {
  pulsos++;
}

void motor() {
  temp = temperatura.getTemperature();
  //funcion de temperatura - pwm
  pv = 70 * log(0.1 * temp + 5) - 20;
  // conforme más caliente más rápido va el motor
  analogWrite(EnB, pv);
  // giro izquierda
  digitalWrite(in3, LOW);
  digitalWrite(in4, HIGH);
}
