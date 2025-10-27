package unze.fooddelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import unze.fooddelivery.data.DemoData;
import unze.fooddelivery.model.Meal;
import unze.fooddelivery.model.Order;
import unze.fooddelivery.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

import static unze.fooddelivery.data.DemoData.mealId;

@Controller
public class AppController {

    @GetMapping("/")
    public String home(){
        return "redirect:/restaurants";
    }

    @GetMapping("/restaurants")
    public String listRestaurants(Model model) {
        model.addAttribute("restaurants", DemoData.getRestaurants());
        return "restaurants";
    }

    @PostMapping("/restaurants/add")
    public String addRestaurant(@RequestParam String name, @RequestParam String location) {
        DemoData.addRestaurant(name, location);
        return "redirect:/restaurants";
    }

    @GetMapping("/restaurants/action/{id}")
    public String restaurantMeals(@PathVariable Long id, Model model) {
        Restaurant restaurant = DemoData.getRestaurantById(id);
        if (restaurant != null) {
            model.addAttribute("restaurant", restaurant);
            model.addAttribute("meals", restaurant.getMeals());
        }
        return "action";
    }

    @PostMapping("/restaurants/action/{restaurantId}/addMeal")
    public String addMealToRestaurant(@PathVariable Long restaurantId,
                                      @RequestParam String name,
                                      @RequestParam double price) {
        Restaurant restaurant = DemoData.getRestaurantById(restaurantId);
        if (restaurant != null) {
            Meal newMeal = new Meal(mealId.incrementAndGet(), name, price);
            restaurant.getMeals().add(newMeal);
        }
        return "redirect:/restaurants/action/" + restaurantId;
    }


    @PostMapping("/restaurants/action/{restaurantId}/order/{mealId}")
    public String orderMealAndView(@PathVariable Long restaurantId,
                                   @PathVariable Long mealId,
                                   Model model) {
        Restaurant restaurant = DemoData.getRestaurantById(restaurantId);
        if (restaurant != null) {
            Meal meal = restaurant.getMeals().stream()
                    .filter(m -> m.getId().equals(mealId))
                    .findFirst()
                    .orElse(null);
            if (meal != null) {
                DemoData.addMealToOrder(restaurant, meal);
            }

            // Dohvati samo narudžbu za taj restoran
            Order order = DemoData.getOrders().stream()
                    .filter(o -> o.getRestaurant().getId().equals(restaurantId))
                    .findFirst()
                    .orElse(null);

            model.addAttribute("orders", order != null ? List.of(order) : List.of());
        }

        return "order"; // order.html sada prikazuje samo tu narudžbu
    }




    @GetMapping("/meals")
    public String listMeals(Model model) {
        List<Meal> uniqueMeals = DemoData.getRestaurants().stream()
                .flatMap(r -> r.getMeals().stream())
                .collect(Collectors.toMap(
                        Meal::getName,   // key = ime jela
                        m -> m,          // value = meal
                        (existing, replacement) -> existing // ako je duplikat, zadrži prvi
                ))
                .values()
                .stream()
                .toList();

        model.addAttribute("meals", uniqueMeals);
        return "meals";
    }


    @GetMapping("/order")
    public String viewOrder(Model model) {
        model.addAttribute("order", DemoData.getOrders());
        return "order";
    }
}
