package unze.fooddelivery.data;

import unze.fooddelivery.model.Meal;
import unze.fooddelivery.model.Order;
import unze.fooddelivery.model.Restaurant;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


/*public class DemoData {
    private static final AtomicLong restaurantId = new AtomicLong(3);
    public static final AtomicLong mealId = new AtomicLong(4);


    private static List<Restaurant> restaurants = new ArrayList<>();
    private static Map<Long, Order> orders = new HashMap<>();

    static {


        Restaurant r1 = new Restaurant(1L, "FastFood Corner", "Sarajevo");
        Restaurant r2 = new Restaurant(2L, "Italiano", "Mostar");

        r1.setMeals(new ArrayList<>(Arrays.asList(m1, m2)));
        r2.setMeals(new ArrayList<>(Arrays.asList(m2, m3)));
        ;

        restaurants.add(r1);
        restaurants.add(r2);
    }

    public static List<Restaurant> getRestaurants() { return restaurants; }

    public static Restaurant getRestaurantById(Long id) {
        return restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    public static void addRestaurant(String name, String location) {
        Restaurant newRestaurant = new Restaurant(
                restaurantId.getAndIncrement(),
                name,
                location
        );
        newRestaurant.setMeals(new ArrayList<>());
        restaurants.add(newRestaurant);
    }

    public static void addMealToOrder(Restaurant restaurant, Meal meal) {
        Order order = orders.computeIfAbsent(restaurant.getId(), rId -> new Order(restaurant));
        order.addMeal(meal);
    }

    public static Collection<Order> getOrders() { return orders.values(); }

}
*/