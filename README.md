# FoodDelivery

**#Članovi**
Arnela Hodžić
Nedžma Imamović

FoodDelivery je jednostavna aplikacija za naručivanje hrane razvijena koristeći **Java**, **Spring Boot**, **MySQL**, **Thymeleaf** i MVC struktura. 
Omogućava korisnicima pregled restorana, jela i dodavanje novih restorana i jela putem web sučelja.
Također omogućava korisnicima da naruče jelo i vide ukupan iznos svoje narudžbe.

## Funkcionalnosti
- Prikaz svih restorana,
- Brisanje restorana,
- Dodavanje novog restorana,
- Prikaz svih jela iz svih restorana,
- Pregled narudžbi u json-u (REST Controller)
- Pregled jela po odabranom restoranu,
- Pregled narudžbi u odabranom restoranu
- Dodavanje novih jela putem web forme,
- Brisanje jela,
- Ažuriranje jela,
- Dodavanje jela u narudžbu,
- Jednostavno i pregledno korisničko sučelje


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
- meals (prikaz svih jela u aplikaciji)
- restaurants (prikaz svih restorana u aplikaciji)
- order (pregled ordera nakon confirm-a)
- action (izlistava sva jela u određenom restoranu, omogućava dodavanje novih jela, brisanje, update i dodavanje jela u order)
- restaurant_order (prikazuje sve ordere za određeni restoran)

Controller:
- AppController (postavljen samo da instancira na prvu rutu /restaurants)
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

3. Pregled svih ordera (JSON)
   <img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/d59456b2-503c-4516-925d-d4f49f8cbc35" />
   
4. Pregled svih jela u jednom restoranu
 <img width="1920" height="877" alt="image" src="https://github.com/user-attachments/assets/b328b666-dc18-4164-8599-9740fc682548" />

5. Potvrda Narudžbe
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/dc204222-41bb-4992-a007-6b88c3578390" />

6. Ažuriranje jela u restoranu
    <img width="1918" height="1071" alt="image" src="https://github.com/user-attachments/assets/7e9d4352-afa1-4e71-9286-2fbd6f168857" />

7. Pregled svih narudžbi u jednom restoranu
   <img width="1920" height="881" alt="image" src="https://github.com/user-attachments/assets/ff9d364b-c649-4e8c-b27d-eb855d5a23fc" />

