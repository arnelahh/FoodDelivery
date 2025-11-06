package unze.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unze.fooddelivery.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
