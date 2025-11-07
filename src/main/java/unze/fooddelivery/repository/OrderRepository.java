package unze.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unze.fooddelivery.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByRestaurant_Id(Long restaurantId);
}
