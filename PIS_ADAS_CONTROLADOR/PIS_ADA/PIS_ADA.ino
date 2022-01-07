  #include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

// Definimos la librerias par la conexion a nuestro servidor
#include "FirebaseESP8266.h"
#include <DHT.h>
#include <Servo.h>

// Definimos el pin digital donde se conecta el sensor
#define DHTPIN 4
#define pinServo 5
const int sensor_pin = A0;

// Dependiendo del tipo de sensor
#define DHTTYPE DHT11
 
// Inicializamos el sensor DHT11
DHT dht(DHTPIN, DHTTYPE);
Servo myServo;

//definimos variables de sensores
float moisture_percentage;
float t;
int h; 
int estado;

//definimos la direccion host de nuestro servidor
#define FIREBASE_HOST "pis-adas-rtdb-default-rtdb.firebaseio.com"
//definimos el token de nuestro servidor
#define FIREBASE_AUTH "GgBHHbzbA4oG3sdxHaTAqldmMAn2KzqC4touy2H0"

//definimos la conexion a punto de acceso wifi
#define WIFI_SSID "Dyllan's_wifi"
#define WIFI_PASSWORD "00wivedody29"

WiFiClient client; 
FirebaseData firebaseData;

void setup() {

  Serial.begin(9600);

  myServo.attach(pinServo);
  myServo.write(0);
  
  WiFi.begin (WIFI_SSID, WIFI_PASSWORD);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500); 
    Serial.print(".");
  }

  Serial.println ("");
  Serial.println ("Se conectó al wifi!");
  Serial.println(WiFi.localIP());
    
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);

  dht.begin();
}

void loop() {
  

  //inicializamos variables de sensores
  t = dht.readTemperature();
  h = dht.readHumidity();
  moisture_percentage = ( 100.00 - ( (analogRead(sensor_pin)/1023.00) * 100.00 ) );

  //se obtiene el angulo de inclinacion para el servomotor
  Firebase.getInt(firebaseData,"PLANTAS/ID_0001/SERVOMOTOR/ESTADO");
  estado = firebaseData.intData();
  myServo.write(estado);
 
  //se setea el valor del sensor DHT11 en la base de datos   
  Firebase.setString(firebaseData,"PLANTAS/ID_0001/DHT11/TA", String(t));  
  Firebase.setString(firebaseData,"PLANTAS/ID_0001/DHT11/HA", String(h));

  //se setea el valor del sensor de humedad de tierra en la base de datos
  Firebase.setString(firebaseData,"PLANTAS/ID_0001/M_SENSOR/HT",String(moisture_percentage));

  
  //se muestra en el monitor serial los valores de cada sensor
  Serial.print("Estado servo:");
  Serial.println(estado);
  Serial.print("Humedad ambiente:");
  Serial.println(h);
  Serial.print("Temperatura ambiente:");
  Serial.println(t);
  Serial.print("Humedad de tierra:");
  Serial.print(moisture_percentage);
  Serial.println("%");
  
  //se espera un segundo antes de tomar otro valor
  delay(1000);
    
}
