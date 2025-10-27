# FoodDelivery

FoodDelivery je jednostavna aplikacija za naručivanje hrane razvijena koristeći **Java**, **Spring Boot**, i **Thymeleaf**. 
Omogućava korisnicima pregled restorana, jela i dodavanje novih restorana i jela putem web sučelja.
Također omogućava korisnicima da naruče jelo i vide ukupan iznos svoje narudžbe.

## Funkcionalnosti
- Prikaz svih restorana.
- Prikaz svih jela iz svih restorana bez ponavljajućih.
- Pregled jela po odabranom restoranu.
- Dodavanje novih restorana putem web forme.
- Dodavanje novih jela putem web forme.
- Dodavanje jela u narudžbu.
- Jednostavno i pregledno korisničko sučelje.

## Tehnologije
- **Java 25**
- **Spring Boot**
- **Thymeleaf**
- **Maven** za upravljanje zavisnostima
- HTML/CSS za front-end

  FoodDelivery/
│
├── src/
│ ├── main/
│ │ ├── java/com/arnela/foodapp/
│ │ │ ├── controller/ # Sadrži Spring kontrolere koji obrađuju HTTP zahtjeve i povezuju servisni sloj s front-endom
│ │ │ ├── model/ # Java klase koje predstavljaju entitete (Restaurant, Meal i Order)
│ │ │ ├── service/ # Logika aplikacije – dodavanje restorana, jela, dohvat podataka
│ │ │ └── FoodAppApplication.java # Glavna klasa za pokretanje Spring Boot aplikacije
│ │ │
│ │ └── resources/
│ │ ├── templates/ # Thymeleaf HTML šabloni za prikaz podataka u web pregledniku
│ │ │ ├── meals.html
│ │ │ ├── restaurants.html
│ │ │ └── order.html
| | | |__ active.html
│ │ ├── static/ # CSS, JS i slike
│ │ │ ├── css/
│ │ │ └── js/
│ │ └── application.properties # Konfiguracija aplikacije (port, logovanje itd.)
│ │
│ └── test/ # Jedinični testovi za servise i kontrolere
│
├── pom.xml # Maven konfiguracija, zavisnosti i plugin-ovi
└── README.md # Ovaj fajl s uputama i opisom projekta
