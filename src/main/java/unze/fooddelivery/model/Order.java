package unze.fooddelivery.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Restaurant restaurant; // spremljen u konstruktoru
    private List<Meal> meals = new ArrayList<>();

    public Order(Restaurant restaurant) {
        this.restaurant = restaurant; // tu čuvaš restoran
    }

    public Restaurant getRestaurant() {
        return restaurant; // samo vraća spremljeni restoran
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getMeals() { return meals; }

    public double getTotal() {
        return meals.stream().mapToDouble(Meal::getPrice).sum();
    }

    public Long getRestaurantId() { return restaurant.getId(); }
    public String getRestaurantName() { return restaurant.getName(); }
}
