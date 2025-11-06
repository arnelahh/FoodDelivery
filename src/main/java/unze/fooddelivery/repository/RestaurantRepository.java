package unze.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unze.fooddelivery.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
