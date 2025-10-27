package unze.fooddelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unze.fooddelivery.data.DemoData;
import unze.fooddelivery.model.Meal;
import unze.fooddelivery.model.Restaurant;

@Controller
public class AppController {
    private final DemoData data;

    public AppController(DemoData data) {
        this.data = data;
    }

    // --- HOME ---
    @GetMapping("/")
    public String home() {
        return "redirect:/restaurants";
    }

    // --- RESTORANI ---
    @GetMapping("/restaurants")
    public String showRestaurants(Model model) {
        model.addAttribute("restaurants", data.findAllRestaurants());
        return "restaurants"; // thymeleaf template
    }

    // --- JELA ---
    @GetMapping("/meals")
    public String showMeals(Model model) {
        model.addAttribute("meals", data.findAllMeals());
        return "meals";
    }

    // --- AKCIJA: narudžba (DEMO primjer) ---
    @PostMapping("/order/{mealId}")
    public String orderMeal(@PathVariable Long mealId, Model model) {
        Meal meal = data.findMeal(mealId);
        if (meal == null) {
            model.addAttribute("message", "Meal not found!");
            return "order";
        }

        model.addAttribute("message", "You successfully ordered: " + meal.getName());
        model.addAttribute("meal", meal);
        return "order";
    }



}
