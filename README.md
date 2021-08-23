# courier
== How to: Build

[source,bash]
mvn clean install

== How to: Start

* create with IDEA a "Run/Debug Configuration" for classes DemoApp.java

* With Maven:
mvn spring-boot:run

== URL of App:
http://localhost:8080/

==Request paths:
GET http://localhost:8080/stores
POST http://localhost:8080/couriers 
{
    "courierId":1,
    "lat":40.9923307,
    "lng":20.1244229
}

GET http://localhost:8080/couriers/{id} (getTotalTravelDistance)


