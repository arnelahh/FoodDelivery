# FoodDelivery

#Članovi tima:
[Arnela Hodžić]
[Nedžma Imamović]

FoodDelivery je jednostavna aplikacija za naručivanje hrane razvijena koristeći **Java**, **Spring Boot**, i **Thymeleaf** i MVC struktura. 
Omogućava korisnicima pregled restorana, jela i dodavanje novih restorana i jela putem web sučelja.
Također omogućava korisnicima da naruče jelo i vide ukupan iznos svoje narudžbe.

## Funkcionalnosti
- Prikaz svih restorana.
- Brisanje restorana,
- Dodavanje novog restorana
- Prikaz svih jela iz svih restorana.
- Pregled jela po odabranom restoranu.
- Dodavanje novih jela putem web forme.
- Brisanje jela
- Ažuriranje jela
- Dodavanje jela u narudžbu.
- Jednostavno i pregledno korisničko sučelje.
- pregled narudžbi u json-u

## Tehnologije
- **Java 25**
- **Spring Boot**
- **Thymeleaf**
- **Maven** za upravljanje zavisnostima
- HTML/CSS za front-end
- MySQL baza podataka

Modeli:
- Meal
- Restaurant
- Order

Views:
- meals
- restaurants
- order
- action
- restaurant_order

Controller:
- AppController
- RestaurantController
- MealController
- OrderController

REST controller:
- OrderRestController

U prilogu slike projekta:
1. /restaurants je prva stranica koja nas dočeka
  <img width="1278" height="802" alt="image" src="https://github.com/user-attachments/assets/699443c9-fc94-411f-8081-6e628ec32251" />

2. Pregled svih jela koja se nalaze u Aplikaciji
   <img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/7a9fc3ec-1566-4ffb-9a8d-cad89a641e40" />

3. Pregled svih jela u jednom restoranu
 <img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/1d955dae-475f-47eb-91cb-008614d328ce" />

4. Potvrda Narudžbe
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/dc204222-41bb-4992-a007-6b88c3578390" />

5. Pregled svih ordera
   <img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/d59456b2-503c-4516-925d-d4f49f8cbc35" />

6. Ažuriranje jela u restoranu
    <img width="1918" height="1071" alt="image" src="https://github.com/user-attachments/assets/7e9d4352-afa1-4e71-9286-2fbd6f168857" />
