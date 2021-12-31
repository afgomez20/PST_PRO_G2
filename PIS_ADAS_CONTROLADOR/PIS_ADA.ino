#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

// Definimos la librerias par la conexion a nuestro servidor
#include "FirebaseESP8266.h"
#include <DHT.h>

// Definimos el pin digital donde se conecta el sensor
#define DHTPIN 4
// Dependiendo del tipo de sensor
#define DHTTYPE DHT11
 
// Inicializamos el sensor DHT11
DHT dht(DHTPIN, DHTTYPE);

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

     float t = dht.readTemperature();
     int h = dht.readHumidity(); 
     
     Firebase.setString(firebaseData,"PLANTAS/ID_0001/DHT11/TA", String(t));  
     Firebase.setString(firebaseData,"PLANTAS/ID_0001/DHT11/HA", String(h));
    
}
