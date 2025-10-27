package unze.fooddelivery.model;

import java.util.List;

public class Restaurant {
    private Long id;
    private String name;
    private String location;
    private List<Meal> meals;

    public Restaurant(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public List<Meal> getMeals() { return meals; }

    public void setMeals(List<Meal> meals) { this.meals = meals; }
}
