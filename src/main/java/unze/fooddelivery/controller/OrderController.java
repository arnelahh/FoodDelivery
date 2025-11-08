package unze.fooddelivery.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import unze.fooddelivery.model.Meal;
import unze.fooddelivery.model.Order;
import unze.fooddelivery.model.Restaurant;
import unze.fooddelivery.repository.RestaurantRepository;
import unze.fooddelivery.service.MealService;
import unze.fooddelivery.service.OrderService;
import unze.fooddelivery.service.RestaurantService;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final RestaurantService restaurantService;
    private final MealService mealService;
    private final OrderService orderService;

    public OrderController(RestaurantService restaurantService, MealService mealService, OrderService orderService) {
        this.restaurantService = restaurantService;
        this.mealService = mealService;
        this.orderService = orderService;
    }

    // Pregled trenutnog order-a iz sessiona
    @GetMapping("/restaurant/{restaurantId}")
    public String showSessionOrder(@PathVariable Long restaurantId, HttpSession session, Model model) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        Order order = orderService.getCurrentOrderForRestaurant(session, restaurantId, restaurant);

        model.addAttribute("order", order);
        return "restaurant_order";
    }

    // Confirm Order: trajno spremi u bazu i vodi na order.html
    @PostMapping("/confirm/{restaurantId}")
    public String confirmOrder(@PathVariable Long restaurantId, HttpSession session, Model model) {



        // dohvat iz sessiona
        Order order = (Order) session.getAttribute("order_" + restaurantId);

        if (order == null || order.getMeals().isEmpty()) {
            // Postavi poruku u model i vrati korisnika natrag na stranicu restorana
            model.addAttribute("errorMessage", "Your order is empty! Please add at least one meal before confirming.");
            Restaurant restaurant = restaurantService.findById(restaurantId);
            model.addAttribute("restaurant", restaurant);
            model.addAttribute("meals", restaurant.getMeals());
            return "redirect:/restaurants/action/" + restaurantId; // ili kako se zove tvoja stranica sa mealovima
        }

        if (order != null && !order.getMeals().isEmpty()) {
            double sum = order.getMeals().stream()
                    .mapToDouble(Meal::getPrice)
                    .sum();
            order.setTotal(sum);
            orderService.save(order); // trajno sprema
            session.removeAttribute("order_" + restaurantId); // očisti session
            model.addAttribute("order", order);
        }

        return "order";
    }

    // Dodavanje meal-a u privremeni order u sessionu
    @PostMapping("/add/{restaurantId}/{mealId}")
    public String addMealToOrder(@PathVariable Long restaurantId,
                                 @PathVariable Long mealId,
                                 HttpSession session) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        Order order = orderService.getCurrentOrderForRestaurant(session, restaurantId, restaurant);
        Meal meal = mealService.findById(mealId);

        order.addMeal(meal);

        return "redirect:/restaurants/action/" + restaurantId;
    }



}
