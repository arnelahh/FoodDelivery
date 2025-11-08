package unze.fooddelivery.service;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import unze.fooddelivery.model.Meal;
import unze.fooddelivery.model.Order;
import unze.fooddelivery.model.Restaurant;
import unze.fooddelivery.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public void save(Order order) {
        repo.save(order);
    }

    // BAZA-BASED: Dohvati posljednji order iz baze za restoran
    public Order getCurrentOrderForRestaurant(Long restaurantId) {
        List<Order> orders = repo.findByRestaurant_Id(restaurantId);
        return orders.isEmpty() ? null : orders.get(orders.size() - 1);
    }

    public List<Order> getAllOrdersById(Long restaurantId) {
        List<Order> orders = repo.findAll();
        return orders.stream()
                .filter(order -> order.getRestaurantId().equals(restaurantId))
                .toList();
    }

    // SESSION-BASED: Dohvati trenutni order iz sessiona (privremeno)
    public Order getCurrentOrderForRestaurant(HttpSession session, Long restaurantId, Restaurant restaurant) {
        String key = "order_" + restaurantId;
        Order order = (Order) session.getAttribute(key);

        if (order == null) {
            order = new Order(restaurant);
            session.setAttribute(key, order);
        }

        if (order.getMeals() == null) {
            order.setMeals(new ArrayList<>());
        }
        return order;
    }
}
