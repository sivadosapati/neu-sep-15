package project.vehicle.management.data;

import java.util.Date;

public class Car {
    private String id;
    private String dealerId;
    private Category category;
    private Integer year;
    private String make;
    private String model;
    private String trim;
    private String type;
    private Float price;

    public Car(String id, String dealerId, Category category, Integer year, String make,
            String model, String trim, String type, Float price) {
        this.setId(id);
        this.dealerId = dealerId;
        this.category = category;
        this.year = year;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.type = type;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /*
     * private Date date; private String imageURL; private String exterior; private String interior;
     */
}
