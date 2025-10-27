package unze.fooddelivery.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private Long id;
    private String name;
    private String location;
    private double rating;
    private String cuisine;
    private List<Meal> meals = new ArrayList<>();

    public Restaurant() {}

    public Restaurant(Long id, String name, String location, double rating, String cuisine) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.cuisine = cuisine;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getRating() {
        return rating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void removeMeal(Long mealId) {
        meals.removeIf(m -> m.getId().equals(mealId));
    }
}
