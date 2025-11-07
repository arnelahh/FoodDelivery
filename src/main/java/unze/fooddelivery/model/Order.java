package unze.fooddelivery.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(nullable = false)
    private Double total = 0.0;


    @ManyToMany
    @JoinTable(
            name = "order_meals",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals = new ArrayList<>();

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Order() {}

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Order(Restaurant restaurant) {
        this.restaurant = restaurant; // tu čuvaš restoran
        this.meals=new ArrayList<>();
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

    public void setTotal(double sum) {
        this.total = sum;
    }
}
