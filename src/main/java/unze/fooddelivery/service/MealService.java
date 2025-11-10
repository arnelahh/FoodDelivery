package unze.fooddelivery.service;

import org.springframework.stereotype.Service;
import unze.fooddelivery.model.Meal;
import unze.fooddelivery.repository.MealRepository;

import java.util.List;

@Service
public class MealService {
    private final MealRepository repo;

    public MealService(MealRepository repo) {
        this.repo = repo;
    }

    public List<Meal> findAllByRestaurant(Long restaurantId){
        return repo.findAllByRestaurantIdAndDeletedFalse(restaurantId);
    }

    public void save(Meal m){
        repo.save(m);
    }

    public void delete(Long id) {
        Meal meal = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found"));
        meal.setDeleted(true);
        repo.save(meal);
    }

    public Meal findById(Long id){
        return repo.findById(id).orElse(null);
    }

    public List<Meal> findAll(){
        return repo.findAllByDeletedFalse();
    }
}


