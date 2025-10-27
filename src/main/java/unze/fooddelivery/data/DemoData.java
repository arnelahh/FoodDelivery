package unze.fooddelivery.data;

import org.springframework.stereotype.Component;
import unze.fooddelivery.model.Meal;
import unze.fooddelivery.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
@Component
public class DemoData {
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<Meal> meals = new ArrayList<>();


    public DemoData() {
        Restaurant r1 = new Restaurant(1L, "Pizza Planet", "Sarajevo", 4.5, "Italian");
        Restaurant r2 = new Restaurant(2L, "Sushi Go", "Tuzla", 4.7, "Japanese");

        Meal m1 = new Meal(1L, "Margherita", 10.0, true, "Classic cheese pizza", 1L);
        Meal m2 = new Meal(2L, "Pepperoni", 12.0, true, "Spicy pepperoni pizza", 1L);
        Meal m3 = new Meal(3L, "California Roll", 15.0, true, "Fresh crab sushi", 2L);

        restaurants.add(r1);
        restaurants.add(r2);

        meals.addAll(List.of(m1, m2, m3));

        r1.addMeal(m1);
        r1.addMeal(m2);
        r2.addMeal(m3);
    }

    public List<Restaurant> findAllRestaurants() { return restaurants; }

    public Restaurant findRestaurant(Long id) {
        return restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    public void addRestaurant(Restaurant r) { restaurants.add(r); }

    public void deleteRestaurant(Long id) { restaurants.removeIf(r -> r.getId().equals(id)); }

    // --- CRUD operacije za MEALS ---
    public List<Meal> findAllMeals() { return meals; }

    public List<Meal> findMealsByRestaurant(Long restaurantId) {
        return meals.stream().filter(m -> m.getRestaurantId().equals(restaurantId)).toList();
    }

    public Meal findMeal(Long id) {
        return meals.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public void addMeal(Meal m) {
        meals.add(m);
        findRestaurant(m.getRestaurantId()).addMeal(m);
    }

    public void deleteMeal(Long id) {
        Meal m = findMeal(id);
        if (m != null) {
            meals.remove(m);
            findRestaurant(m.getRestaurantId()).removeMeal(id);
        }
    }
}
