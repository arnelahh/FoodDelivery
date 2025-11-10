package unze.fooddelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unze.fooddelivery.model.Restaurant;
import unze.fooddelivery.model.Meal;
import unze.fooddelivery.service.MealService;
import unze.fooddelivery.service.RestaurantService;

@Controller
@RequestMapping("/meals")
public class MealController {
    private final MealService mealService;
    private final RestaurantService restaurantService;

    public MealController(MealService mealService, RestaurantService restaurantService) {
        this.mealService = mealService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{restaurantId}")
    public String showMealsForRestaurant(@PathVariable Long restaurantId, Model model) {
        Restaurant r = restaurantService.findById(restaurantId);
        model.addAttribute("restaurant", r);
        model.addAttribute("meals", mealService.findAllByRestaurant(restaurantId));
        return "meals";
    }

    @PostMapping("/add/{restaurantId}")
    public String addMeal(@PathVariable Long restaurantId, @ModelAttribute Meal meal){
        Restaurant r = restaurantService.findById(restaurantId);
        meal.setRestaurant(r);
        mealService.save(meal);
        return "redirect:/restaurants/action/" + restaurantId;
    }

    @GetMapping("/delete/{restaurantId}/{mealId}")
    public String deleteMeal(@PathVariable Long restaurantId, @PathVariable Long mealId) {
        mealService.delete(mealId);
        return "redirect:/restaurants/action/" + restaurantId;
    }

    @GetMapping
    public String showAllMeals(Model model){
        model.addAttribute("meals", mealService.findAll());
        return "meals";
    }

    @PutMapping("/update/{mealId}")
    @ResponseBody
    public String updateMeal(@PathVariable Long mealId,
                             @RequestParam String name,
                             @RequestParam double price) {
        Meal meal = mealService.findById(mealId);
        if (meal != null) {
            meal.setName(name);
            meal.setPrice(price);
            mealService.save(meal);
            return "OK";
        }
        return "Meal not found";
    }



}
