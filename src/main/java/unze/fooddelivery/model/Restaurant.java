package unze.fooddelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "restaurant_meals",
            joinColumns = @JoinColumn(name="restaurant_id"),
            inverseJoinColumns = @JoinColumn(name="meal_id")
    )
    @JsonIgnoreProperties("restaurants")
    private List<Meal> meals;

    public Restaurant(){}

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
