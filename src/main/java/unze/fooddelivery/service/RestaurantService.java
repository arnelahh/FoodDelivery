package unze.fooddelivery.service;

import org.springframework.stereotype.Service;
import unze.fooddelivery.model.Restaurant;
import unze.fooddelivery.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository repo;

    public RestaurantService(RestaurantRepository repo) {
        this.repo = repo;
    }

    public List<Restaurant> findAll(){
        return repo.findAll();
    }

    public Restaurant findById(Long id){
        return repo.findById(id).orElse(null);
    }

    public Restaurant save(Restaurant restaurant){
        return repo.save(restaurant);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
