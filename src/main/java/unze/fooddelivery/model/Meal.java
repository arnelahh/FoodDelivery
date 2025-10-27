package unze.fooddelivery.model;

public class Meal {
    private Long id;
    private String name;
    private double price;
    private boolean available;
    private String description;

    private Long restaurantId; // referenca na restoran kojem pripada

    public Meal(Long id, String name, double price, boolean available, String description, Long restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
        this.description = description;
        this.restaurantId = restaurantId;
    }

    public Meal() {
    }

    // --- GETTERI I SETTERI ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
