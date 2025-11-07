package unze.fooddelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unze.fooddelivery.model.Meal;
import unze.fooddelivery.model.Restaurant;
import unze.fooddelivery.repository.MealRepository;
import unze.fooddelivery.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository repo;

    public RestaurantService(RestaurantRepository repo) {
        this.repo = repo;
    }

    @Autowired
    private MealRepository mealRepository;

    public List<Restaurant> findAll(){
        return repo.findAllByDeletedFalse();
    }

    public Restaurant findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public void save(Restaurant restaurant){
        repo.save(restaurant);
    }

    public void delete(Long id) {
        Restaurant restaurant = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        restaurant.setDeleted(true);
        for (Meal meal : restaurant.getMeals()) {
            meal.setDeleted(true);
            mealRepository.save(meal);
        }
        repo.save(restaurant);
    }
}
