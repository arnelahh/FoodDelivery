package unze.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unze.fooddelivery.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAllByDeletedFalse();
}
