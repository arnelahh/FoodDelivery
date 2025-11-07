package unze.fooddelivery.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unze.fooddelivery.model.Meal;
import unze.fooddelivery.model.Order;
import unze.fooddelivery.model.Restaurant;
import unze.fooddelivery.service.MealService;
import unze.fooddelivery.service.RestaurantService;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService service;
    private final MealService mealService;
    public RestaurantController(RestaurantService service, MealService mealService)
    {
        this.service = service;
        this.mealService = mealService;
    }



    @GetMapping
    public String showAllRestaurants(Model model){
        model.addAttribute("restaurants", service.findAll());
        return "restaurants";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Restaurant r){
        service.save(r);
        return "redirect:/restaurants";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/restaurants";
    }


    @GetMapping("/action/{id}")
    public String showRestaurantMeals(@PathVariable Long id, Model model, HttpSession session){
        Restaurant r = service.findById(id);
        model.addAttribute("restaurant", r);
        model.addAttribute("meals", mealService.findAllByRestaurant(id));


        String key = "order_" + id;
        Order order = (Order) session.getAttribute(key);
        if(order == null){
            order = new Order(r);
        }
        model.addAttribute("order", order);

        model.addAttribute("newMeal", new Meal());
        return "action";
    }

}
